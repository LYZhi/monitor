package com.lyzhi.monitor.agent.business.server.service;

import com.lyzhi.monitor.agent.annotation.TargetInf;
import com.lyzhi.monitor.agent.annotation.TargetMethod;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;

/**
 * <p>
 * 跟服务端相关的告警服务接口
 * </p>
 *
 */
@TargetInf(inf = IAlarmService.class)
public interface IAlarmService {

    /**
     * <p>
     * 给服务端发告警包
     * </p>
     *
     * @param alarmPackage 告警包
     * @return {@link BaseResponsePackage}
     * @throws Exception 所有异常
     *
     */
    @TargetMethod(method = "sendAlarmPackage")
    BaseResponsePackage sendAlarmPackage(AlarmPackage alarmPackage) throws Exception;
}
