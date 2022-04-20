package com.lyzhi.monitor.agent.business.server.service.impl;

import com.lyzhi.monitor.agent.business.server.service.IBaseRequestPackageService;
import com.lyzhi.monitor.agent.business.server.service.IHttpService;
import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.TreeSet;

/**
 * <p>
 * 跟服务端相关的基础请求包服务实现
 * </p>
 *
 */
@Service
public class BaseRequestPackageServiceImpl implements IBaseRequestPackageService {

    /**
     * 跟服务端相关的HTTP服务接口
     */
    @Autowired
    private IHttpService httpService;

    /**
     * <p>
     * 给服务端发基础请求包
     * </p>
     *
     * @param baseRequestPackage 基础请求包
     * @param url                URL路径
     * @return {@link BaseResponsePackage}
     * @throws Exception 所有异常
     *
     */
    @Override
    public BaseResponsePackage sendBaseRequestPackage(BaseRequestPackage baseRequestPackage, String url) throws Exception {
        // IP地址
        String ip = ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp() == null ? NetUtils.getLocalIp() : ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp();
        // 请求包地址链中添加当前IP地址
        TreeSet<String> requestNetworkChain = baseRequestPackage.getNetworkChain();
        requestNetworkChain.add(ip);
        baseRequestPackage.setNetworkChain(requestNetworkChain);
        BaseResponsePackage baseResponsePackage = this.httpService.sendHttpPost(baseRequestPackage.toJsonString(), url);
        // 响应包地址链中添加当前IP地址
        TreeSet<String> responseNetworkChain = baseResponsePackage.getNetworkChain();
        responseNetworkChain.add(ip);
        baseResponsePackage.setNetworkChain(responseNetworkChain);
        return baseResponsePackage;
    }

}
