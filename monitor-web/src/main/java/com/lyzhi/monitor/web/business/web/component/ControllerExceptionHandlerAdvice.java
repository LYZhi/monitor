package com.lyzhi.monitor.web.business.web.component;

import com.lyzhi.monitor.web.business.web.vo.LayUiAdminResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 监控UI端web业务的全局异常捕获
 * </p>
 *
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.lyzhi.monitor.web.business.web.controller")
public class ControllerExceptionHandlerAdvice {

    /**
     * <p>
     * 捕捉异常并进行处理
     * </p>
     *
     * @param throwable {@link Throwable}
     * @return LayUiAdmin响应对象
     *
     */
    @ExceptionHandler(value = Throwable.class)
    public LayUiAdminResultVo handler(Throwable throwable) {
        log.error("异常：", throwable);
        return LayUiAdminResultVo.fail(throwable.toString());
    }

}
