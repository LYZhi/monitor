package com.lyzhi.monitor.common.dto;

import com.lyzhi.monitor.common.domain.Jvm;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * Java虚拟机信息包
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class JvmPackage extends BaseRequestPackage {

    /**
     * Java虚拟机信息
     */
    private Jvm jvm;

    /**
     * 传输频率
     */
    private long rate;

}
