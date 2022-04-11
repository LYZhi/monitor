package com.lyzhi.monitor.server.business.server.monitor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.common.constant.*;
import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.threadpool.ThreadPool;
import com.lyzhi.monitor.common.util.DateTimeUtils;
import com.lyzhi.monitor.common.util.Md5Utils;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.server.business.server.core.MonitoringConfigPropertiesLoader;
import com.lyzhi.monitor.server.business.server.entity.MonitorTcpIp;
import com.lyzhi.monitor.server.business.server.service.IAlarmService;
import com.lyzhi.monitor.server.business.server.service.ITcpIpService;
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
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 * 在项目启动后，定时扫描数据库“MONITOR_TCPIP”表中的所有TCP/IP信息，更新TCP/IP服务状态，发送告警。
 * </p>
 *
 */
@Slf4j
@Component
@Order(7)
public class TcpIpMonitorJob extends QuartzJobBean {

    /**
     * 告警服务接口
     */
    @Autowired
    private IAlarmService alarmService;

    /**
     * TCP/IP信息服务接口
     */
    @Autowired
    private ITcpIpService tcpIpService;

    /**
     * <p>
     * 扫描数据库“MONITOR_TCPIP”表中的所有TCP/IP信息，实时更新TCP/IP服务状态，发送告警。
     * </p>
     *
     * @param jobExecutionContext 作业执行上下文
     *
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        // 是否监控TCP/IP服务
        boolean isMonitoringEnable = MonitoringConfigPropertiesLoader.getMonitoringProperties().getTcpIpProperties().isEnable();
        if (!isMonitoringEnable) {
            return;
        }
        try {
            // 获取TCP/IP信息列表
            List<MonitorTcpIp> monitorTcpIps = this.tcpIpService.list(new LambdaQueryWrapper<MonitorTcpIp>().eq(MonitorTcpIp::getIpSource, NetUtils.getLocalIp()));
            // 循环处理每一个TCP/IP信息
            for (MonitorTcpIp monitorTcpIp : monitorTcpIps) {
                // 目标IP地址
                String ipTarget = monitorTcpIp.getIpTarget();
                // 目标端口号
                Integer portTarget = monitorTcpIp.getPortTarget();
                // 协议
                String protocol = monitorTcpIp.getProtocol();
                TcpIpEnums protocolEnum = TcpIpEnums.str2Enum(protocol);
                // 使用多线程，加快处理速度
                ThreadPoolExecutor threadPoolExecutor = ThreadPool.COMMON_IO_INTENSIVE_THREAD_POOL;
                threadPoolExecutor.execute(() -> {
                    // 测试telnet能否成功
                    boolean isConnected = NetUtils.telnet(ipTarget, portTarget, protocolEnum);
                    // TCP/IP服务正常
                    if (isConnected) {
                        // 处理TCP/IP服务正常
                        this.connected(monitorTcpIp);
                    }
                    // TCP/IP服务异常
                    else {
                        // 处理TCP/IP服务异常
                        this.disconnected(monitorTcpIp);
                    }
                });
            }
        } catch (NetException e) {
            log.error("定时扫描数据库“MONITOR_TCPIP”表中的所有TCP/IP信息异常！", e);
        }
    }

    /**
     * <p>
     * 处理TCP/IP服务异常
     * </p>
     *
     * @param monitorTcpIp TCP/IP信息表
     *
     */
    private void disconnected(MonitorTcpIp monitorTcpIp) {
        try {
            this.sendAlarmInfo("TCP/IP服务中断", AlarmLevelEnums.FATAL, AlarmReasonEnums.NORMAL_2_ABNORMAL, monitorTcpIp);
        } catch (Exception e) {
            log.error("TCP/IP服务告警异常！", e);
        }
        // 原本是在线或者未知
        String status = monitorTcpIp.getStatus();
        if (StringUtils.equalsIgnoreCase(status, ZeroOrOneConstants.ONE) || StringUtils.isBlank(status)) {
            // 离线次数 +1
            int offlineCount = monitorTcpIp.getOfflineCount() == null ? 0 : monitorTcpIp.getOfflineCount();
            monitorTcpIp.setOfflineCount(offlineCount + 1);
        }
        monitorTcpIp.setStatus(ZeroOrOneConstants.ZERO);
        monitorTcpIp.setUpdateTime(new Date());
        // 更新数据库
        this.tcpIpService.updateById(monitorTcpIp);
    }

    /**
     * <p>
     * 处理TCP/IP服务正常
     * </p>
     *
     * @param monitorTcpIp TCP/IP信息表
     *
     */
    private void connected(MonitorTcpIp monitorTcpIp) {
        try {
            if (StringUtils.isNotBlank(monitorTcpIp.getStatus())) {
                this.sendAlarmInfo("TCP/IP服务恢复", AlarmLevelEnums.INFO, AlarmReasonEnums.ABNORMAL_2_NORMAL, monitorTcpIp);
            }
        } catch (Exception e) {
            log.error("TCP/IP服务告警异常！", e);
        }
        monitorTcpIp.setStatus(ZeroOrOneConstants.ONE);
        monitorTcpIp.setUpdateTime(new Date());
        // 更新数据库
        this.tcpIpService.updateById(monitorTcpIp);
    }

    /**
     * <p>
     * 发送告警信息
     * </p>
     *
     * @param title           告警标题
     * @param alarmLevelEnum  告警级别
     * @param alarmReasonEnum 告警原因
     * @param monitorTcpIp    TCP/IP信息
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常
     *
     */
    private void sendAlarmInfo(String title, AlarmLevelEnums alarmLevelEnum, AlarmReasonEnums alarmReasonEnum, MonitorTcpIp monitorTcpIp) throws NetException, SigarException {
        StringBuilder builder = new StringBuilder();
        builder.append("源IP：").append(monitorTcpIp.getIpSource())
                .append("，<br>目标IP：").append(monitorTcpIp.getIpTarget())
                .append("，<br>目标端口：").append(monitorTcpIp.getPortTarget())
                .append("，<br>协议：").append(monitorTcpIp.getProtocol());
        if (StringUtils.isNotBlank(monitorTcpIp.getDescr())) {
            builder.append("，<br>描述：").append(monitorTcpIp.getDescr());
        }
        builder.append("，<br>时间：").append(DateTimeUtils.dateToString(new Date()));
        Alarm alarm = Alarm.builder()
                // 保证code的唯一性
                .code(Md5Utils.encrypt32(monitorTcpIp.getIpSource() + monitorTcpIp.getIpTarget() + monitorTcpIp.getPortTarget()))
                .title(title)
                .msg(builder.toString())
                .alarmLevel(alarmLevelEnum)
                .alarmReason(alarmReasonEnum)
                .monitorType(MonitorTypeEnums.TCPIP4SERVICE)
                .build();
        AlarmPackage alarmPackage = new PackageConstructor().structureAlarmPackage(alarm);
        this.alarmService.dealAlarmPackage(alarmPackage);
    }

}
