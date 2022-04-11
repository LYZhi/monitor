package com.lyzhi.monitor.common.property.server;

import lombok.*;

/**
 * <p>
 * TCP/IP配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringTcpIpProperties {

    /**
     * 是否监控网络
     */
    private boolean enable;

}
