package com.lyzhi.monitor.common.property.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 监控属性
 */
@Data
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class MonitoringProperties {

    /**
     * 与服务端相关的监控属性
     */
    private MonitoringServerProperties serverProperties;

    /**
     * 与自己相关的监控属性
     */
    private MonitoringOwnProperties ownProperties;

    /**
     * 心跳属性
     */
    private MonitoringHeartbeatProperties heartbeatProperties;

    /**
     * 服务器信息属性
     */
    private MonitoringServerInfoProperties serverInfoProperties;

    /**
     * Java虚拟机信息属性
     */
    private MonitoringJvmInfoProperties jvmInfoProperties;

}
