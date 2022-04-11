package com.lyzhi.monitor.server.business.server.service;

import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.AlarmPackage;

import java.util.concurrent.Future;

/**
 * <p>
 * 告警服务接口
 * </p>
 *
 */
public interface IAlarmService {

    /**
     * <p>
     * 异步处理告警包
     * </p>
     *
     * @param alarmPackage 告警包
     * @return {@link Future}
     *
     */
    Future<Result> dealAlarmPackage(AlarmPackage alarmPackage);

}
