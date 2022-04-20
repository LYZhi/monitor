package com.lyzhi.monitor.agent.business.server.service.impl;

import com.lyzhi.monitor.agent.business.server.service.IHttpService;
import com.lyzhi.monitor.agent.business.server.service.IServerService;
import com.lyzhi.monitor.agent.constant.UrlConstants;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.ServerPackage;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

/**
 * <p>
 * 跟服务端相关的服务器信息服务实现类
 * </p>
 *
 */
@Service
public class ServerServiceImpl implements IServerService {

    /**
     * 跟服务端相关的HTTP服务接口
     */
    @Autowired
    private IHttpService httpService;

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
    @Override
    public BaseResponsePackage sendServerPackage(ServerPackage serverPackage) throws Exception {
        // IP地址
        String ip = ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp() == null ? NetUtils.getLocalIp() : ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp();
        // 请求包地址链中添加当前IP地址
        TreeSet<String> requestNetworkChain = serverPackage.getNetworkChain();
        requestNetworkChain.add(ip);
        serverPackage.setNetworkChain(requestNetworkChain);
        BaseResponsePackage baseResponsePackage = this.httpService.sendHttpPost(serverPackage.toJsonString(), UrlConstants.SERVER_URL);
        // 响应包地址链中添加当前IP地址
        TreeSet<String> responseNetworkChain = baseResponsePackage.getNetworkChain();
        responseNetworkChain.add(ip);
        baseResponsePackage.setNetworkChain(responseNetworkChain);
        return baseResponsePackage;
    }

}
