package com.lyzhi.monitor.common.domain;


import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import com.lyzhi.monitor.common.domain.server.*;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务器信息
 * </p>
 *
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public final class Server extends AbstractSuperBean {

    /**
     * 操作系统信息
     */
    private OsDomain osDomain;

    /**
     * 内存信息
     */
    private MemoryDomain memoryDomain;

    /**
     * Cpu信息
     */
    private CpuDomain cpuDomain;

    /**
     * 网卡信息
     */
    private NetDomain netDomain;

    /**
     * 磁盘信息
     */
    private DiskDomain diskDomain;

    /**
     * 电池信息
     */
    private PowerSourcesDomain powerSourcesDomain;

    /**
     * 传感器信息
     */
    private SensorsDomain sensorsDomain;

    /**
     * 进程信息
     */
    private ProcessDomain processDomain;

}
