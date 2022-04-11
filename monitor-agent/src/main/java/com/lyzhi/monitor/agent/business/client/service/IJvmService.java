package com.lyzhi.monitor.agent.business.client.service;

import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.JvmPackage;

/**
 * <p>
 * Java虚拟机信息服务接口
 * </p>
 *
 */
public interface IJvmService {

    /**
     * <p>
     * 处理Java虚拟机信息包
     * </p>
     *
     * @param jvmPackage Java虚拟机信息包
     * @return {@link BaseResponsePackage}
     *
     */
    BaseResponsePackage dealJvmPackage(JvmPackage jvmPackage);

}
