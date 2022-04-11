package com.lyzhi.monitor.agent.config;

import com.lyzhi.monitor.client.core.Monitor;
import com.lyzhi.monitor.common.property.client.MonitoringProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * <p>
 * 生产环境监控代理配置
 * </p>
 *
 */
@Configuration
@Profile("prod")
public class MonitoringAgentProdConfig {

    /**
     * <p>
     * 开启监控
     * </p>
     *
     * @return {@link MonitoringProperties}
     *
     */
    @Bean
    public MonitoringProperties init() {
        return Monitor.start(null, "monitoring-prod.properties");
    }

}
