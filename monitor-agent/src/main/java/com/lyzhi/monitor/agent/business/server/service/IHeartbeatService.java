package com.lyzhi.monitor.agent.business.server.service;

import com.lyzhi.monitor.agent.annotation.TargetInf;
import com.lyzhi.monitor.agent.annotation.TargetMethod;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.HeartbeatPackage;

/**
 * <p>
 * 跟服务端相关的心跳服务接口
 * </p>
 *
 */
@TargetInf(inf = IHeartbeatService.class)
public interface IHeartbeatService {

    /**
     * <p>
     * 给服务端发心跳包
     * </p>
     *
     * @param heartbeatPackage 心跳包对象
     * @return {@link BaseResponsePackage}
     * @throws Exception 所有异常
     *
     */
    @TargetMethod(method = "sendHeartbeatPackage")
    BaseResponsePackage sendHeartbeatPackage(HeartbeatPackage heartbeatPackage) throws Exception;

}
