package com.lyzhi.monitor.common.property.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Java虚拟机信息属性
 */
@Data
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class MonitoringJvmInfoProperties {

    /**
     * 是否采集Java虚拟机信息
     */
    private boolean enable;

    /**
     * 发送Java虚拟机信息的频率
     */
    private long rate;

}
