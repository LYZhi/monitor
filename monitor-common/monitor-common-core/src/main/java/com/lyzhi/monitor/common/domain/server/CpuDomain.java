package com.lyzhi.monitor.common.domain.server;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * CPU信息
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CpuDomain extends AbstractSuperBean {

    /**
     * cpu总数
     */
    private int cpuNum;
    /**
     * cpu信息
     */
    private List<CpuInfoDomain> cpuList;

    @Data
    @ToString
    @NoArgsConstructor
    @Accessors(chain = true)
    @EqualsAndHashCode(callSuper = true)
    public static class CpuInfoDomain extends AbstractSuperBean {

        /**
         * CPU频率（MHz）
         */
        int cpuMhz;

        /**
         * CPU卖主
         */
        String cpuVendor;

        /**
         * CPU的类别，如：Celeron
         */
        String cpuModel;

        /**
         * CPU用户使用率
         */
        double cpuUser;

        /**
         * CPU系统使用率
         */
        double cpuSys;

        /**
         * CPU等待率
         */
        double cpuWait;

        /**
         * CPU错误率
         */
        double cpuNice;

        /**
         * CPU剩余率
         */
        double cpuIdle;

        /**
         * CPU使用率
         */
        double cpuCombined;

    }

}
