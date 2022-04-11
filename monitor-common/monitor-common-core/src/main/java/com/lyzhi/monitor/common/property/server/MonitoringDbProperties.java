package com.lyzhi.monitor.common.property.server;

import com.lyzhi.monitor.common.inf.ISuperBean;
import lombok.*;

/**
 * <p>
 * 数据库配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringDbProperties implements ISuperBean {

    /**
     * 是否监控数据库
     */
    private boolean enable;

    /**
     * 数据库表空间配置属性
     */
    private MonitoringDbTableSpaceProperties dbTableSpaceProperties;

}
