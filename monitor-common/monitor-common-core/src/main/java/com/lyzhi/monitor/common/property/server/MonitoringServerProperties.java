package com.lyzhi.monitor.common.property.server;

import com.lyzhi.monitor.common.inf.ISuperBean;
import lombok.*;

/**
 * <p>
 * 服务器配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringServerProperties implements ISuperBean {

    /**
     * 是否监控服务器
     */
    private boolean enable;

    /**
     * 服务器CPU配置属性
     */
    private MonitoringServerCpuProperties serverCpuProperties;

    /**
     * 服务器磁盘配置属性
     */
    private MonitoringServerDiskProperties serverDiskProperties;

    /**
     * 服务器内存配置属性
     */
    private MonitoringServerMemoryProperties serverMemoryProperties;

}
