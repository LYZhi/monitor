package com.lyzhi.monitor.agent.business.client.service.impl;

import com.lyzhi.monitor.agent.business.client.service.IAlarmService;
import com.lyzhi.monitor.agent.core.MethodExecuteHandler;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 告警服务实现
 * </p>
 *
 */
@Service
public class AlarmServiceImpl implements IAlarmService {

    /**
     * <p>
     * 处理告警包
     * </p>
     *
     * @param heartbeatPackage 告警包
     * @return {@link BaseResponsePackage}
     *
     */
    @Override
    public BaseResponsePackage dealAlarmPackage(AlarmPackage heartbeatPackage) {
        // 把告警包转发到服务端
        return MethodExecuteHandler.sendAlarmPackage2Server(heartbeatPackage);
    }

}

	