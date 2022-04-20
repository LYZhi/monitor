package com.lyzhi.monitor.common.dto;

import com.lyzhi.monitor.common.domain.Server;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务器信息包
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class ServerPackage extends BaseRequestPackage {

    /**
     * 服务器信息
     */
    private Server server;

    /**
     * 传输频率
     */
    private long rate;

}
