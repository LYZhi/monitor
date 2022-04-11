package com.lyzhi.monitor.server.business.server.monitor;

import cn.hutool.db.DbUtil;
import cn.hutool.db.ds.simple.SimpleDataSource;
import cn.hutool.db.handler.NumberHandler;
import cn.hutool.db.sql.SqlExecutor;
import com.baomidou.mybatisplus.annotation.DbType;
import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.common.constant.*;
import com.lyzhi.monitor.common.constant.sql.MySql;
import com.lyzhi.monitor.common.constant.sql.Oracle;
import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.threadpool.ThreadPool;
import com.lyzhi.monitor.common.util.DateTimeUtils;
import com.lyzhi.monitor.common.util.Md5Utils;
import com.lyzhi.monitor.server.business.server.core.MonitoringConfigPropertiesLoader;
import com.lyzhi.monitor.server.business.server.entity.MonitorDb;
import com.lyzhi.monitor.server.business.server.service.IAlarmService;
import com.lyzhi.monitor.server.business.server.service.IDbService;
import com.lyzhi.monitor.server.db.MongoUtils;
import com.lyzhi.monitor.server.db.RedisUtils;
import com.mongodb.MongoClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hyperic.sigar.SigarException;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 * 在项目启动后，定时扫描数据库“MONITOR_DB”表中的所有数据库信息，更新数据库状态，发送告警。
 * </p>
 *
 */
@Slf4j
@Component
@Order(4)
public class DbMonitorJob extends QuartzJobBean {

    /**
     * 告警服务接口
     */
    @Autowired
    private IAlarmService alarmService;

    /**
     * 数据库表服务接口
     */
    @Autowired
    private IDbService dbService;

    /**
     * 扫描数据库“MONITOR_DB”表中的所有数据库信息，实时更新数据库状态，发送告警。
     *
     * @param jobExecutionContext 作业执行上下文
     *
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        // 是否监控数据库
        boolean isEnable = MonitoringConfigPropertiesLoader.getMonitoringProperties().getDbProperties().isEnable();
        if (!isEnable) {
            return;
        }
        try {
            // 查询数据库中的所有数据库信息
            List<MonitorDb> monitorDbs = this.dbService.list();
            for (MonitorDb monitorDb : monitorDbs) {
                // 使用多线程，加快处理速度
                ThreadPoolExecutor threadPoolExecutor = ThreadPool.COMMON_IO_INTENSIVE_THREAD_POOL;
                threadPoolExecutor.execute(() -> {
                    String dbType = monitorDb.getDbType();
                    // 关系型数据库
                    if (StringUtils.equalsIgnoreCase(DbEnums.MySQL.name(), dbType)
                            || StringUtils.equalsIgnoreCase(DbEnums.Oracle.name(), dbType)) {
                        // 处理关系型数据库
                        this.dealRelationalDb(monitorDb);
                    }
                    // Redis数据库
                    if (StringUtils.equalsIgnoreCase(DbEnums.Redis.name(), dbType)) {
                        // 处理Redis数据库
                        this.dealRedisDb(monitorDb);
                    }
                    // mongo数据库
                    if (StringUtils.equalsIgnoreCase(DbEnums.Mongo.name(), dbType)) {
                        // 处理MongoDB
                        this.dealMongoDb(monitorDb);
                    }
                });
            }
        } catch (Exception e) {
            log.error("定时扫描数据库“MONITOR_DB”表中的所有数据库信息异常！", e);
        }
    }

    /**
     * <p>
     * 处理MongoDB
     * </p>
     *
     * @param monitorDb 数据库信息
     *
     */
    private void dealMongoDb(MonitorDb monitorDb) {
        MongoClient mongoClient = null;
        try {
            String url = monitorDb.getUrl();
            // 获取 MongoClient
            mongoClient = MongoUtils.getClient(url);
            // Mongo数据库是否可连接
            boolean isConnect = MongoUtils.isConnect(mongoClient);
            // 连接正常
            if (isConnect) {
                // 处理数据库正常
                this.connected(monitorDb);
            }
            // 连接异常
            else {
                // 处理数据库异常
                this.disconnected(monitorDb);
            }
        } catch (Exception e) {
            // 处理数据库异常
            this.disconnected(monitorDb);
            log.error("执行数据库监控异常！", e);
        } finally {
            MongoUtils.close(mongoClient);
        }
    }

    /**
     * <p>
     * 处理Redis数据库
     * </p>
     *
     * @param monitorDb 数据库信息
     *
     */
    private void dealRedisDb(MonitorDb monitorDb) {
        Jedis jedis = null;
        try {
            String url = monitorDb.getUrl();
            String[] address = StringUtils.split(url, ":");
            // 主机
            String host = address[0];
            // 端口
            int port = Integer.parseInt(address[1]);
            // 密码
            String password = monitorDb.getPassword();
            // 获取 Jedis
            jedis = RedisUtils.getJedis(host, port, password);
            // Redis数据库是否可连接
            boolean isConnect = RedisUtils.isConnect(jedis);
            // 连接正常
            if (isConnect) {
                // 处理数据库正常
                this.connected(monitorDb);
            }
            // 连接异常
            else {
                // 处理数据库异常
                this.disconnected(monitorDb);
            }
        } catch (Exception e) {
            // 处理数据库异常
            this.disconnected(monitorDb);
            log.error("执行数据库监控异常！", e);
        } finally {
            RedisUtils.close(jedis);
        }
    }

    /**
     * <p>
     * 处理关系型数据库
     * </p>
     *
     * @param monitorDb 数据库信息
     *
     */
    private void dealRelationalDb(MonitorDb monitorDb) {
        // 关系型数据库连接
        Connection connection = this.getRelationalDbConnection(monitorDb);
        try {
            // 关系型数据库是否可连接
            boolean isConnect = this.isRelationalDbConnect(connection, monitorDb);
            // 连接正常
            if (isConnect) {
                // 处理数据库正常
                this.connected(monitorDb);
            }
            // 连接异常
            else {
                // 处理数据库异常
                this.disconnected(monitorDb);
            }
        } catch (Exception e) {
            // 处理数据库异常
            this.disconnected(monitorDb);
            log.error("执行数据库监控异常！", e);
        } finally {
            DbUtil.close(connection);
        }
    }

    /**
     * <p>
     * 处理数据库异常
     * </p>
     *
     * @param monitorDb 数据库信息
     *
     */
    private void disconnected(MonitorDb monitorDb) {
        try {
            this.sendAlarmInfo("数据库连接异常", AlarmLevelEnums.FATAL, AlarmReasonEnums.NORMAL_2_ABNORMAL, monitorDb);
        } catch (Exception e) {
            log.error("数据库告警异常！", e);
        }
        // 原本是在线或者未知
        String isOnline = monitorDb.getIsOnline();
        if (StringUtils.equalsIgnoreCase(isOnline, ZeroOrOneConstants.ONE) || StringUtils.isBlank(isOnline)) {
            // 离线次数 +1
            int offlineCount = monitorDb.getOfflineCount() == null ? 0 : monitorDb.getOfflineCount();
            monitorDb.setOfflineCount(offlineCount + 1);
        }
        monitorDb.setIsOnline(ZeroOrOneConstants.ZERO);
        monitorDb.setUpdateTime(new Date());
        // 更新数据库
        this.dbService.updateById(monitorDb);
    }

    /**
     * <p>
     * 处理数据库正常
     * </p>
     *
     * @param monitorDb 数据库信息
     *
     */
    private void connected(MonitorDb monitorDb) {
        try {
            if (StringUtils.isNotBlank(monitorDb.getIsOnline())) {
                this.sendAlarmInfo("数据库连接恢复", AlarmLevelEnums.INFO, AlarmReasonEnums.ABNORMAL_2_NORMAL, monitorDb);
            }
        } catch (Exception e) {
            log.error("数据库告警异常！", e);
        }
        monitorDb.setIsOnline(ZeroOrOneConstants.ONE);
        monitorDb.setUpdateTime(new Date());
        // 更新数据库
        this.dbService.updateById(monitorDb);
    }

    /**
     * <p>
     * 获取关系型数据库连接
     * </p>
     *
     * @param monitorDb 数据库信息
     * @return 数据库连接
     *
     */
    private Connection getRelationalDbConnection(MonitorDb monitorDb) {
        // url
        String url = monitorDb.getUrl();
        // 用户名
        String username = monitorDb.getUsername();
        // 密码
        String password = new String(Base64.getDecoder().decode(monitorDb.getPassword()), StandardCharsets.UTF_8);
        // 数据源
        try (SimpleDataSource ds = new SimpleDataSource(url, username, password)) {
            return ds.getConnection();
        } catch (Exception e) {
            log.error("与数据库建立连接异常！", e);
            return null;
        }
    }

    /**
     * <p>
     * 关系型数据库是否可连接
     * </p>
     *
     * @param connection 数据库连接
     * @param monitorDb  数据库表
     * @return 是 或者 否
     *
     */
    private boolean isRelationalDbConnect(Connection connection, MonitorDb monitorDb) {
        // 数据库连接为空
        if (connection == null) {
            return false;
        }
        try {
            String dbType = monitorDb.getDbType();
            // mysql
            if (StringUtils.equalsIgnoreCase(dbType, DbType.MYSQL.getDb())) {
                SqlExecutor.query(connection, MySql.CHECK_CONN, new NumberHandler());
            }
            // oracle
            if (StringUtils.equalsIgnoreCase(dbType, DbType.ORACLE.getDb())) {
                SqlExecutor.query(connection, Oracle.CHECK_CONN, new NumberHandler());
            }
            return true;
        } catch (Exception e) {
            log.error("检查连接异常！", e);
            return false;
        }
    }

    /**
     * <p>
     * 发送告警信息
     * </p>
     *
     * @param title           告警标题
     * @param alarmLevelEnum  告警级别
     * @param alarmReasonEnum 告警原因
     * @param monitorDb       数据库信息
     * @throws NetException   获取数据库信息异常
     * @throws SigarException Sigar异常
     *
     */
    private void sendAlarmInfo(String title, AlarmLevelEnums alarmLevelEnum, AlarmReasonEnums alarmReasonEnum, MonitorDb monitorDb) throws NetException, SigarException {
        StringBuilder builder = new StringBuilder();
        // 数据库类型
        String dbType = monitorDb.getDbType();
        builder.append("连接名：").append(monitorDb.getConnName());
        if (StringUtils.equalsIgnoreCase(DbEnums.Redis.name(), dbType)) {
            builder.append("，<br>地址：");
        } else {
            builder.append("，<br>URL：");
        }
        builder.append(monitorDb.getUrl())
                .append("，<br>类型：").append(dbType);
        if (StringUtils.isNotBlank(monitorDb.getDbDesc())) {
            builder.append("，<br>描述：").append(monitorDb.getDbDesc());
        }
        builder.append("，<br>时间：").append(DateTimeUtils.dateToString(new Date()));
        Alarm alarm = Alarm.builder()
                // 保证code的唯一性
                .code(Md5Utils.encrypt32(monitorDb.getUrl() + monitorDb.getUsername()))
                .title(title)
                .msg(builder.toString())
                .alarmLevel(alarmLevelEnum)
                .alarmReason(alarmReasonEnum)
                .monitorType(MonitorTypeEnums.DATABASE)
                .build();
        AlarmPackage alarmPackage = new PackageConstructor().structureAlarmPackage(alarm);
        this.alarmService.dealAlarmPackage(alarmPackage);
    }

}
