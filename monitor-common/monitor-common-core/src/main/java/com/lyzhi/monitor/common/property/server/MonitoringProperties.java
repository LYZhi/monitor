package com.lyzhi.monitor.common.property.server;

import com.lyzhi.monitor.common.inf.ISuperBean;
import lombok.*;

/**
 * <p>
 * 监控配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringProperties implements ISuperBean {

    /**
     * 监控阈值
     */
    private int threshold;

    /**
     * 告警属性
     */
    private MonitoringAlarmProperties alarmProperties;

    /**
     * 网络属性
     */
    private MonitoringNetworkProperties networkProperties;

    /**
     * TCP属性
     */
    private MonitoringTcpProperties tcpProperties;

    /**
     * 服务器属性
     */
    private MonitoringServerProperties serverProperties;

    /**
     * 数据库配置属性
     */
    private MonitoringDbProperties dbProperties;

}
