package com.lyzhi.monitor.common.property.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 与服务端相关的监控属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class MonitoringServerProperties {

    /**
     * 监控服务端url
     */
    private String url;
    /**
     * 连接超时时间（毫秒）
     */
    private int connectTimeout;
    /**
     * 等待数据超时时间（毫秒）
     */
    private int socketTimeout;
    /**
     * 从连接池获取连接的等待超时时间（毫秒）
     */
    private int connectionRequestTimeout;

}
