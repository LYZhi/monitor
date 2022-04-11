package com.lyzhi.monitor.agent.business.client.service.impl;

import com.lyzhi.monitor.agent.business.client.service.IHeartbeatService;
import com.lyzhi.monitor.agent.core.MethodExecuteHandler;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.HeartbeatPackage;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 心跳服务实现类
 * </p>
 *
 */
@Service
public class HeartbeatServiceImpl implements IHeartbeatService {

    /**
     * <p>
     * 处理心跳包
     * </p>
     *
     * @param heartbeatPackage 心跳包
     * @return {@link BaseResponsePackage}
     *
     */
    @Override
    public BaseResponsePackage dealHeartbeatPackage(HeartbeatPackage heartbeatPackage) {
        // 把心跳包转发到服务端
        return MethodExecuteHandler.sendHeartbeatPackage2Server(heartbeatPackage);
    }

}
