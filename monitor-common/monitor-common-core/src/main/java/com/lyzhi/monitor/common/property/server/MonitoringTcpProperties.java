package com.lyzhi.monitor.common.property.server;

import lombok.*;

/**
 * <p>
 * TCP配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringTcpProperties {

    /**
     * 是否监控网络
     */
    private boolean enable;

}
