package com.lyzhi.monitor.server.business.server.component;

import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.dto.CiphertextPackage;
import com.lyzhi.monitor.common.web.toolkit.HttpInputMessagePackageEncrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <p>
 * 响应包加密增强
 * </p>
 *
 */
@RestControllerAdvice(basePackages = "com.gitee.pifeng.monitoring.server.business.server.controller")
@Slf4j
public class ResponsePackageEncryptAdvice implements ResponseBodyAdvice<Object> {

    /**
     * <p>
     * 捕捉异常并进行处理
     * </p>
     *
     * @param throwable {@link Throwable}
     * @return 密文数据包 {@link CiphertextPackage}
     *
     */
    @ExceptionHandler(value = Throwable.class)
    public CiphertextPackage handler(Throwable throwable) {
        log.error("异常：", throwable);
        Result build = Result.builder().isSuccess(false).msg(throwable.toString()).build();
        BaseResponsePackage baseResponsePackage = new PackageConstructor().structureBaseResponsePackage(build);
        return new HttpInputMessagePackageEncrypt().encrypt(baseResponsePackage);
    }

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
