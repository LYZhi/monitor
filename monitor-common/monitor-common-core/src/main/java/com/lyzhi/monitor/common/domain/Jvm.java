package com.lyzhi.monitor.common.domain;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import com.lyzhi.monitor.common.domain.jvm.*;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * Java虚拟机信息
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
public class Jvm extends AbstractSuperBean {

    /**
     * 类加载信息
     */
    private ClassLoadingDomain classLoadingDomain;

    /**
     * GC信息
     */
    private GarbageCollectorDomain garbageCollectorDomain;

    /**
     * 内存信息
     */
    private MemoryDomain memoryDomain;

    /**
     * JVM运行时信息
     */
    private RuntimeDomain runtimeDomain;

    /**
     * 线程信息
     */
    private ThreadDomain threadDomain;

}
