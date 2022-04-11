package com.lyzhi.monitor.common.property.server;

import com.lyzhi.monitor.common.inf.ISuperBean;
import lombok.*;

/**
 * <p>
 * 网络配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringNetworkProperties implements ISuperBean {

    /**
     * 是否监控网络
     */
    private boolean enable;

}
