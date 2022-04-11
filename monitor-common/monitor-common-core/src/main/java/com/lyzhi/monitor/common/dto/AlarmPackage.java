package com.lyzhi.monitor.common.dto;

import com.lyzhi.monitor.common.domain.Alarm;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 监控告警信息包
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class AlarmPackage extends BaseRequestPackage {

    /**
     * 告警对象
     */
    private Alarm alarm;

}
