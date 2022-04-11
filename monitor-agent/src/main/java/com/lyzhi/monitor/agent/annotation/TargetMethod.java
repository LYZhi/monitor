package com.lyzhi.monitor.agent.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 自定义指定代理执行方法的注解
 * </p>
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetMethod {

    /**
     * <p>
     * 指定代理执行方法
     * </p>
     *
     * @return 方法名
     *
     */
    String method();
}
