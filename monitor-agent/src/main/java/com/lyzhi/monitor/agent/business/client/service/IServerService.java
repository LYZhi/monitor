package com.lyzhi.monitor.agent.business.client.service;

import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.ServerPackage;

/**
 * <p>
 * 服务器信息服务接口
 * </p>
 *
 */
public interface IServerService {

    /**
     * <p>
     * 处理服务器信息包
     * </p>
     *
     * @param serverPackage 服务器信息包
     * @return {@link BaseResponsePackage}
     *
     */
    BaseResponsePackage dealServerPackage(ServerPackage serverPackage);

}
