package com.lyzhi.monitor.web.config;

import com.lyzhi.monitor.client.springboot.starter.annotation.EnableMonitoring;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * <p>
 * 开发环境监控配置
 * </p>
 *
 */
@Configuration
@Profile("dev")
@EnableMonitoring(configFilePath = "classpath:/", configFileName = "monitoring-dev.properties")
public class MonitoringUiDevConfig {
}
