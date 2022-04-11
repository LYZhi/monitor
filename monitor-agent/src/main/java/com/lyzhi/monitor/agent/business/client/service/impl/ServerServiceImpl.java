package com.lyzhi.monitor.agent.business.client.service.impl;

import com.lyzhi.monitor.agent.business.client.service.IServerService;
import com.lyzhi.monitor.agent.core.MethodExecuteHandler;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.ServerPackage;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器信息服务实现
 * </p>
 *
 */
@Service
public class ServerServiceImpl implements IServerService {

    /**
     * <p>
     * 处理服务器信息包
     * </p>
     *
     * @param serverPackage 服务器信息包
     * @return {@link BaseResponsePackage}
     *
     */
    @Override
    public BaseResponsePackage dealServerPackage(ServerPackage serverPackage) {
        // 把服务器信息包转发到服务端
        return MethodExecuteHandler.sendServerPackage2Server(serverPackage);
    }

}
