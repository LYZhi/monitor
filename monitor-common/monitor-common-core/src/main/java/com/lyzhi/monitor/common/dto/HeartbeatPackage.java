package com.lyzhi.monitor.common.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 心跳包
 * </p>
 *
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
