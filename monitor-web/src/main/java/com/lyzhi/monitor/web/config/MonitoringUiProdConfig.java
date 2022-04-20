package com.lyzhi.monitor.web.config;

import com.lyzhi.monitor.client.springboot.starter.annotation.EnableMonitoring;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * <p>
 * 生产环境监控配置
 * </p>
 *
 */
@Configuration
@Profile("prod")
@EnableMonitoring(configFilePath = "classpath:/", configFileName = "monitoring-prod.properties")
public class MonitoringUiProdConfig {
}
