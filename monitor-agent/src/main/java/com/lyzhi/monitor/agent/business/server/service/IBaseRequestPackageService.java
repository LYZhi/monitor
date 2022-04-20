package com.lyzhi.monitor.agent.business.server.service;

import com.lyzhi.monitor.agent.annotation.TargetInf;
import com.lyzhi.monitor.agent.annotation.TargetMethod;
import com.lyzhi.monitor.common.dto.BaseRequestPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;

/**
 * <p>
 * 跟服务端相关的基础请求包服务接口
 * </p>
 *
 */
@TargetInf(inf = IBaseRequestPackageService.class)
public interface IBaseRequestPackageService {

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
    @TargetMethod(method = "sendBaseRequestPackage")
    BaseResponsePackage sendBaseRequestPackage(BaseRequestPackage baseRequestPackage, String url) throws Exception;

}
