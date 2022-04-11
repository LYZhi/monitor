package com.lyzhi.monitor.agent.business.client.component;

import com.lyzhi.monitor.agent.business.client.controller.*;
import com.lyzhi.monitor.common.web.toolkit.HttpInputMessagePackageEncrypt;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <p>
 * 响应包加密增强
 * </p>
 *
 */
@RestControllerAdvice(basePackageClasses = {
        AlarmController.class,
        HeartbeatController.class,
        ServerController.class,
        JvmController.class,
        MonitoringPropertiesConfigController.class
})
public class ResponsePackageEncryptAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 总开关：是否启用响应包加密
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (null != body) {
            // 加密
            return new HttpInputMessagePackageEncrypt().encrypt(body);
        }
        return null;
    }
}
