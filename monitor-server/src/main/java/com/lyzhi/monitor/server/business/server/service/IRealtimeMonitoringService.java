package com.lyzhi.monitor.server.business.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.server.business.server.entity.MonitorRealtimeMonitoring;

/**
 * <p>
 * 实时监控服务接口
 * </p>
 *
 */
public interface IRealtimeMonitoringService extends IService<MonitorRealtimeMonitoring> {

    /**
     * <p>
     * 对告警进行前置判断，防止重复发送相同的告警
     * </p>
     *
     * @param alarm 告警信息
     * @return boolean
     *
     */
    boolean beforeAlarmJudge(Alarm alarm);

}
