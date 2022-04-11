package com.lyzhi.monitor.agent.business.client.service;

import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;

/**
 * <p>
 * 基础请求包服务接口
 * </p>
 *
 */
public interface IBaseRequestPackageService {

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
    BaseResponsePackage dealBaseRequestPackage(BaseRequestPackage baseRequestPackage, String url);

}
