package com.lyzhi.monitor.common.property.server;


import com.lyzhi.monitor.common.inf.ISuperBean;
import lombok.*;

/**
 * <p>
 * 告警邮箱配置属性
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonitoringAlarmMailProperties implements ISuperBean {

    /**
     * 收件人邮箱地址
     */
    private String[] emills;

}
