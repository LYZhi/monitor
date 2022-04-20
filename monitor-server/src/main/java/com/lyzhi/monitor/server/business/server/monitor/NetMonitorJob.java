package com.lyzhi.monitor.server.business.server.monitor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.common.constant.AlarmLevelEnums;
import com.lyzhi.monitor.common.constant.AlarmReasonEnums;
import com.lyzhi.monitor.common.constant.MonitorTypeEnums;
import com.lyzhi.monitor.common.constant.ZeroOrOneConstants;
import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.threadpool.ThreadPool;
import com.lyzhi.monitor.common.util.DateTimeUtils;
import com.lyzhi.monitor.common.util.Md5Utils;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.server.business.server.core.MonitoringConfigPropertiesLoader;
import com.lyzhi.monitor.server.business.server.entity.MonitorNet;
import com.lyzhi.monitor.server.business.server.service.IAlarmService;
import com.lyzhi.monitor.server.business.server.service.INetService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hyperic.sigar.SigarException;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 * 在项目启动后，定时扫描数据库“MONITOR_NET”表中的所有网络信息，更新网络状态，发送告警。
 * </p>
 *
 */
@Slf4j
@Component
@Order(3)
public class NetMonitorJob extends QuartzJobBean {

    /**
     * 告警服务接口
     */
    @Autowired
    private IAlarmService alarmService;

    /**
     * 网络信息服务接口
     */
    @Autowired
    private INetService netService;

    /**
     * 扫描数据库“MONITOR_NET”表中的所有网络信息，实时更新网络状态，发送告警。
     *
     * @param jobExecutionContext 作业执行上下文
     *
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        // 是否监控网络
        boolean isMonitoringEnable = MonitoringConfigPropertiesLoader.getMonitoringProperties().getNetworkProperties().isEnable();
        if (!isMonitoringEnable) {
            return;
        }
        try {
            // 获取网络信息列表
            List<MonitorNet> monitorNets = this.netService.list(new LambdaQueryWrapper<MonitorNet>().eq(MonitorNet::getIpSource, NetUtils.getLocalIp()));
            // 循环处理每一个网络信息
            for (MonitorNet monitorNet : monitorNets) {
                // 目标IP地址
                String ipTarget = monitorNet.getIpTarget();
                // 使用多线程，加快处理速度
                ThreadPoolExecutor threadPoolExecutor = ThreadPool.COMMON_IO_INTENSIVE_THREAD_POOL;
                threadPoolExecutor.execute(() -> {
                    Map<String, Object> objectMap = NetUtils.isConnect(ipTarget);
                    // 测试IP地址能否ping通
                    boolean isConnected = Boolean.parseBoolean(String.valueOf(objectMap.get("isConnect")));
                    // 平均响应时间
                    String avgTime = String.valueOf(objectMap.get("avgTime"));
                    // 网络正常
                    if (isConnected) {
                        // 处理网络正常
                        this.connected(monitorNet, avgTime);
                    }
                    // 网络异常
                    else {
                        // 处理网络异常
                        this.disconnected(monitorNet, avgTime);
                    }
                });
            }
        } catch (NetException e) {
            log.error("定时扫描数据库“MONITOR_NET”表中的所有网络信息异常！", e);
        }
    }

    /**
     * <p>
     * 处理网络异常
     * </p>
     *
     * @param monitorNet 网络信息表
     * @param avgTime    平均响应时间
     *
     */
    private void disconnected(MonitorNet monitorNet, String avgTime) {
        try {
            this.sendAlarmInfo("网络中断", AlarmLevelEnums.FATAL, AlarmReasonEnums.NORMAL_2_ABNORMAL, monitorNet);
        } catch (Exception e) {
            log.error("网络告警异常！", e);
        }
        // 原本是在线或者未知
        String status = monitorNet.getStatus();
        if (StringUtils.equalsIgnoreCase(status, ZeroOrOneConstants.ONE) || StringUtils.isBlank(status)) {
            // 离线次数 +1
            int offlineCount = monitorNet.getOfflineCount() == null ? 0 : monitorNet.getOfflineCount();
            monitorNet.setOfflineCount(offlineCount + 1);
        }
        monitorNet.setStatus(ZeroOrOneConstants.ZERO);
        monitorNet.setAvgTime(avgTime);
        monitorNet.setUpdateTime(new Date());
        // 更新数据库
        this.netService.updateById(monitorNet);
    }

    /**
     * <p>
     * 处理网络正常
     * </p>
     *
     * @param monitorNet 网络信息
     * @param avgTime    平均响应时间
     *
     */
    private void connected(MonitorNet monitorNet, String avgTime) {
        try {
            if (StringUtils.isNotBlank(monitorNet.getStatus())) {
                this.sendAlarmInfo("网络恢复", AlarmLevelEnums.INFO, AlarmReasonEnums.ABNORMAL_2_NORMAL, monitorNet);
            }
        } catch (Exception e) {
            log.error("网络告警异常！", e);
        }
        monitorNet.setStatus(ZeroOrOneConstants.ONE);
        monitorNet.setAvgTime(avgTime);
        monitorNet.setUpdateTime(new Date());
        // 更新数据库
        this.netService.updateById(monitorNet);
    }

    /**
     * <p>
     * 发送告警信息
     * </p>
     *
     * @param title           告警标题
     * @param alarmLevelEnum  告警级别
     * @param alarmReasonEnum 告警原因
     * @param net             网络信息
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常
     *
     */
    private void sendAlarmInfo(String title, AlarmLevelEnums alarmLevelEnum, AlarmReasonEnums alarmReasonEnum, MonitorNet net) throws NetException, SigarException {
        StringBuilder builder = new StringBuilder();
        builder.append("源IP：").append(net.getIpSource())
                .append("，<br>目标IP：").append(net.getIpTarget());
        if (StringUtils.isNotBlank(net.getIpDesc())) {
            builder.append("，<br>描述：").append(net.getIpDesc());
        }
        builder.append("，<br>时间：").append(DateTimeUtils.dateToString(new Date()));
        Alarm alarm = Alarm.builder()
                // 保证code的唯一性
                .code(Md5Utils.encrypt32(net.getIpSource() + net.getIpTarget()))
                .title(title)
                .msg(builder.toString())
                .alarmLevel(alarmLevelEnum)
                .alarmReason(alarmReasonEnum)
                .monitorType(MonitorTypeEnums.NET)
                .build();
        AlarmPackage alarmPackage = new PackageConstructor().structureAlarmPackage(alarm);
        this.alarmService.dealAlarmPackage(alarmPackage);
    }

}