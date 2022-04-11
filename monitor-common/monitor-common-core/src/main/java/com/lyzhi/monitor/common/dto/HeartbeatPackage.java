package com.lyzhi.monitor.common.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 心跳包
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class HeartbeatPackage extends BaseRequestPackage {

    /**
     * 心跳频率
     */
    private long rate;

}
