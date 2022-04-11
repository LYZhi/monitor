package com.lyzhi.monitor.agent.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 自定义指定代理接口的注解
 * </p>
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetInf {

    /**
     * <p>
     * 指定接口
     * </p>
     *
     * @return {@link Class}
     *
     */
    Class<?> inf();
}