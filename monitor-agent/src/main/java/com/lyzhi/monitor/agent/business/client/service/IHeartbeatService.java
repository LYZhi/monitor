package com.lyzhi.monitor.agent.business.client.service;

import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.HeartbeatPackage;

/**
 * <p>
 * 心跳服务接口
 * </p>
 *
 */
public interface IHeartbeatService {

    /**
     * <p>
     * 处理心跳包
     * </p>
     *
     * @param heartbeatPackage 心跳包
     * @return {@link BaseResponsePackage}
     *
     */
    BaseResponsePackage dealHeartbeatPackage(HeartbeatPackage heartbeatPackage);

}
