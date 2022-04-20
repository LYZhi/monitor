package com.lyzhi.monitor.server.business.server.monitor;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyzhi.monitor.common.constant.AlarmLevelEnums;
import com.lyzhi.monitor.common.constant.AlarmReasonEnums;
import com.lyzhi.monitor.common.constant.MonitorTypeEnums;
import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.util.DateTimeUtils;
import com.lyzhi.monitor.common.util.Md5Utils;
import com.lyzhi.monitor.server.business.server.core.MonitoringConfigPropertiesLoader;
import com.lyzhi.monitor.server.business.server.core.PackageConstructor;
import com.lyzhi.monitor.server.business.server.entity.MonitorServer;
import com.lyzhi.monitor.server.business.server.entity.MonitorServerMemory;
import com.lyzhi.monitor.server.business.server.service.IAlarmService;
import com.lyzhi.monitor.server.business.server.service.IServerMemoryService;
import com.lyzhi.monitor.server.business.server.service.IServerService;
import com.lyzhi.monitor.server.inf.IServerMonitoringListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 监控服务器内存信息，实时更新状态，发送告警
 * </p>
 *
 */
@Component
@Slf4j
public class ServerMemoryMonitor implements IServerMonitoringListener {

    /**
     * 告警服务接口
     */
    @Autowired
    private IAlarmService alarmService;

    /**
     * 服务器内存信息服务层接口
     */
    @Autowired
    private IServerMemoryService serverMemoryService;

    /**
     * 服务器信息服务层接口
     */
    @Autowired
    private IServerService serverService;

    /**
     * <p>
     * 监控内存使用率，发送内存过载告警信息
     * </p>
     *
     * @param obj 回调参数
     *
     */
    @Override
    public void wakeUpMonitor(Object... obj) {
        // 是否监控服务器
        boolean isEnable = MonitoringConfigPropertiesLoader.getMonitoringProperties().getServerProperties().isEnable();
        // 不需要监控服务器
        if (!isEnable) {
            return;
        }
        String ip = String.valueOf(obj[0]);
        // 查询此IP的服务器CPU信息
        MonitorServerMemory monitorServerMemory = this.serverMemoryService.getOne(new LambdaQueryWrapper<MonitorServerMemory>().eq(MonitorServerMemory::getIp, ip));
        if (monitorServerMemory == null) {
            return;
        }
        // 过载阈值
        double overloadThreshold = MonitoringConfigPropertiesLoader.getMonitoringProperties().getServerProperties().getServerMemoryProperties().getOverloadThreshold();
        // 物理内存使用率
        double menUsedPercent = NumberUtil.round(monitorServerMemory.getMenUsedPercent() * 100D, 2).doubleValue();
        // 物理内存使用率大于等于配置的过载阈值
        if (menUsedPercent >= overloadThreshold) {
            // 处理物理内存过载
            this.dealMemoryOverLoad(ip, menUsedPercent);
        } else {
            // 处理物理内存正常
            this.dealMemoryNotOverLoad(ip, menUsedPercent);
        }
    }

    /**
     * <p>
     * 处理物理内存正常
     * </p>
     *
     * @param ip             IP地址
     * @param menUsedPercent 物理内存使用率
     *
     */
    private void dealMemoryNotOverLoad(String ip, double menUsedPercent) {
        MonitorServer monitorServer = this.serverService.getOne(new LambdaQueryWrapper<MonitorServer>().eq(MonitorServer::getIp, ip));
        String serverName = monitorServer.getServerName();
        String serverSummary = monitorServer.getServerSummary();
        // 发送告警信息
        try {
            // 不用担心头次检测到内存正常（非异常转正常）会发送告警，最终是否发送告警由“实时监控服务”决定
            this.sendAlarmInfo("服务器内存恢复正常", ip, serverName, serverSummary, menUsedPercent, AlarmLevelEnums.INFO, AlarmReasonEnums.ABNORMAL_2_NORMAL);
        } catch (Exception e) {
            log.error("服务器内存恢复正常告警异常！", e);
        }
    }

    /**
     * <p>
     * 处理物理内存过载
     * </p>
     *
     * @param ip             IP地址
     * @param menUsedPercent 物理内存使用率
     *
     */
    private void dealMemoryOverLoad(String ip, double menUsedPercent) {
        MonitorServer monitorServer = this.serverService.getOne(new LambdaQueryWrapper<MonitorServer>().eq(MonitorServer::getIp, ip));
        String serverName = monitorServer.getServerName();
        String serverSummary = monitorServer.getServerSummary();
        // 告警级别
        AlarmLevelEnums alarmLevelEnum = MonitoringConfigPropertiesLoader.getMonitoringProperties().getServerProperties().getServerMemoryProperties().getLevelEnum();
        // 发送告警信息
        try {
            this.sendAlarmInfo("服务器内存过载", ip, serverName, serverSummary, menUsedPercent, alarmLevelEnum, AlarmReasonEnums.NORMAL_2_ABNORMAL);
        } catch (Exception e) {
            log.error("服务器内存过载告警异常！", e);
        }
    }

    /**
     * <p>
     * 发送告警信息
     * </p>
     *
     * @param title           告警标题
     * @param ip              IP地址
     * @param serverName      服务器名
     * @param serverSummary   服务器摘要
     * @param menUsedPercent  物理内存使用率
     * @param alarmLevelEnum  告警级别
     * @param alarmReasonEnum 告警原因
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常
     *
     */
    private void sendAlarmInfo(String title, String ip, String serverName, String serverSummary, double menUsedPercent,
                               AlarmLevelEnums alarmLevelEnum, AlarmReasonEnums alarmReasonEnum) throws NetException, SigarException {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append("IP地址：").append(ip).append("，<br>服务器：").append(serverName);
        if (StringUtils.isNotBlank(serverSummary)) {
            msgBuilder.append("，<br>服务器描述：").append(serverSummary);
        }
        msgBuilder.append("，<br>内存使用率：").append(menUsedPercent).append("%，<br>时间：").append(DateTimeUtils.dateToString(new Date()));
        Alarm alarm = Alarm.builder()
                // 保证code的唯一性
                .code(Md5Utils.encrypt32(ip + serverName + ServerMemoryMonitor.class.getName()))
                .title(title)
                .msg(msgBuilder.toString())
                .alarmLevel(alarmLevelEnum)
                .alarmReason(alarmReasonEnum)
                .monitorType(MonitorTypeEnums.SERVER)
                .build();
        AlarmPackage alarmPackage = new PackageConstructor().structureAlarmPackage(alarm);
        this.alarmService.dealAlarmPackage(alarmPackage);
    }
}
