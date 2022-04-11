package com.lyzhi.monitor.agent.business.client.service.impl;

import com.lyzhi.monitor.agent.business.client.service.IBaseRequestPackageService;
import com.lyzhi.monitor.agent.core.MethodExecuteHandler;
import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 基础请求包服务实现
 * </p>
 *
 */
@Service
public class BaseRequestPackageServiceImpl implements IBaseRequestPackageService {

    /**
     * <p>
     * 处理基础请求包
     * </p>
     *
     * @param baseRequestPackage 基础请求包
     * @param url                URL路径
     * @return {@link BaseResponsePackage}
     *
     */
    @Override
    public BaseResponsePackage dealBaseRequestPackage(BaseRequestPackage baseRequestPackage, String url) {
        // 把基础请求包转发到服务端
        return MethodExecuteHandler.sendBaseRequestPackage2Server(baseRequestPackage, url);
    }

}
