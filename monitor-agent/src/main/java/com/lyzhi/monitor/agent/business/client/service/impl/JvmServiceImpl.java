package com.lyzhi.monitor.agent.business.client.service.impl;

import com.lyzhi.monitor.agent.business.client.service.IJvmService;
import com.lyzhi.monitor.agent.core.MethodExecuteHandler;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.JvmPackage;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Java虚拟机信息服务实现
 * </p>
 *
 */
@Service
public class JvmServiceImpl implements IJvmService {

    /**
     * <p>
     * 处理Java虚拟机信息包
     * </p>
     *
     * @param jvmPackage Java虚拟机信息包
     * @return {@link BaseResponsePackage}
     *
     */
    @Override
    public BaseResponsePackage dealJvmPackage(JvmPackage jvmPackage) {
        // 把Java虚拟机信息包转发到服务端
        return MethodExecuteHandler.sendJvmPackage2Server(jvmPackage);
    }
}
