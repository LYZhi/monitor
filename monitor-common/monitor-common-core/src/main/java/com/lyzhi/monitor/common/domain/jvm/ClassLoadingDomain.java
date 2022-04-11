package com.lyzhi.monitor.common.domain.jvm;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 类加载信息
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
public class ClassLoadingDomain extends AbstractSuperBean {

    /**
     * 加载的类的总数
     */
    private long totalLoadedClassCount;

    /**
     * 当前加载的类的总数
     */
    private int loadedClassCount;

    /**
     * 卸载的类总数
     */
    private long unloadedClassCount;

    /**
     * 是否启用了类加载系统的详细输出
     */
    private boolean isVerbose;
}
