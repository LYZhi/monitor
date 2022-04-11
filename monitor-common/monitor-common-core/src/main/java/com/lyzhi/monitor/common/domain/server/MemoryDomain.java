package com.lyzhi.monitor.common.domain.server;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 内存信息
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
public class MemoryDomain extends AbstractSuperBean {

    /**
     * 内存信息
     */
    private MenDomain menDomain;

    /**
     * 交换区信息
     */
    private SwapDomain swapDomain;

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    @EqualsAndHashCode(callSuper = true)
    public static class MenDomain extends AbstractSuperBean {

        /**
         * 物理内存总量（单位：byte）
         */
        private long memTotal;

        /**
         * 物理内存使用量（单位：byte）
         */
        private long memUsed;

        /**
         * 物理内存剩余量（单位：byte）
         */
        private long memFree;

        /**
         * 物理内存使用率
         */
        private double menUsedPercent;
    }

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    @EqualsAndHashCode(callSuper = true)
    public static class SwapDomain extends AbstractSuperBean {

        /**
         * 交换区总量（单位：byte）
         */
        private long swapTotal;

        /**
         * 交换区使用量（单位：byte）
         */
        private long swapUsed;

        /**
         * 交换区剩余量（单位：byte）
         */
        private long swapFree;

        /**
         * 交换区使用率
         */
        private double swapUsedPercent;
    }

}
