package com.lyzhi.monitor.web.business.web.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 自定义操作日志注解
 * </p>
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {

    /**
     * <p>
     * 操作模块
     * </p>
     *
     * @return 操作模块
     *
     */
    String operModule();

    /**
     * <p>
     * 操作类型
     * </p>
     *
     * @return 操作类型
     *
     */
    String operType();

    /**
     * <p>
     * 操作说明
     * </p>
     *
     * @return 操作说明
     *
     */
    String operDesc() default "";

}
