package com.lyzhi.monitor.common.domain.jvm;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * GC信息
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
public class GarbageCollectorDomain extends AbstractSuperBean {

    /**
     * 详细GC信息列表
     */
    private List<GarbageCollectorInfoDomain> garbageCollectorInfoDomains;


    /**
     * <p>
     * 详细GC信息
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
    public static class GarbageCollectorInfoDomain extends AbstractSuperBean {

        /**
         * 内存管理器名称
         */
        private String name;

        /**
         * GC总次数
         */
        private String collectionCount;

        /**
         * GC总时间（毫秒）
         */
        private String collectionTime;

    }

}
