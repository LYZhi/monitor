package com.lyzhi.monitor.common.property.server;

import com.lyzhi.monitor.common.constant.AlarmLevelEnums;
import com.lyzhi.monitor.common.inf.ISuperBean;
import lombok.*;

/**
 * <p>
 * 服务器内存配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringServerMemoryProperties implements ISuperBean {

    /**
     * 过载阈值
     */
    private double overloadThreshold;

    /**
     * 监控级别，四级：INFO &#60; WARN &#60; ERROR &#60; FATAL
     */
    private AlarmLevelEnums levelEnum;

}
