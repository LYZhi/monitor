package com.lyzhi.monitor.agent.business.server.service;

import com.lyzhi.monitor.agent.annotation.TargetInf;
import com.lyzhi.monitor.agent.annotation.TargetMethod;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.ServerPackage;

/**
 * <p>
 * 跟服务端相关的服务器信息服务接口
 * </p>
 *
 */
@TargetInf(inf = IServerService.class)
public interface IServerService {

    /**
     * <p>
     * 给服务端发服务器信息包
     * </p>
     *
     * @param serverPackage 服务器信息包
     * @return {@link BaseResponsePackage}
     * @throws Exception 所有异常
     *
     */
    @TargetMethod(method = "sendServerPackage")
    BaseResponsePackage sendServerPackage(ServerPackage serverPackage) throws Exception;
}
