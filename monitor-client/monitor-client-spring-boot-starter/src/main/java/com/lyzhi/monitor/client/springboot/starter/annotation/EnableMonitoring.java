package com.lyzhi.monitor.client.springboot.starter.annotation;

import com.lyzhi.monitor.client.springboot.starter.selector.EnableMonitoringPlugSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>
 * 开启监控功能
 * </p>
 *
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
// 导入注册springboot类
@Import({EnableMonitoringPlugSelector.class})
@Documented
public @interface EnableMonitoring {

    /**
     * <p>
     * 设置配置文件路径<br>
     * 例如：configFilePath = "classpath:conf/"
     * </p>
     *
     * @return 配置文件路径
     *
     */
    String configFilePath() default "";

    /**
     * <p>
     * 设置配置文件名字<br>
     * 例如：configFileName = "monitoring.properties"
     * </p>
     *
     * @return 配置文件名字
     *
     */
    String configFileName() default "";

}
