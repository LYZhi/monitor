package com.lyzhi.monitor.agent.business.server.service;

import com.lyzhi.monitor.agent.annotation.TargetInf;
import com.lyzhi.monitor.agent.annotation.TargetMethod;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.JvmPackage;

/**
 * <p>
 * 跟服务端相关的Java虚拟机信息服务接口
 * </p>
 *
 */
@TargetInf(inf = IJvmService.class)
public interface IJvmService {

    /**
     * <p>
     * 给服务端发Java虚拟机信息包
     * </p>
     *
     * @param jvmPackage Java虚拟机信息包
     * @return {@link BaseResponsePackage}
     * @throws Exception 所有异常
     *
     */
    @TargetMethod(method = "sendJvmPackage")
    BaseResponsePackage sendServerPackage(JvmPackage jvmPackage) throws Exception;

}
