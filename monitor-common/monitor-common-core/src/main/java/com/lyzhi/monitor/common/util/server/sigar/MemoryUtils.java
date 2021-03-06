package com.lyzhi.monitor.common.util.server.sigar;

import com.lyzhi.monitor.common.domain.server.MemoryDomain;
import com.lyzhi.monitor.common.init.InitSigar;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

/**
 * <p>
 * 内存工具类
 * </p>
 *
 */
public class MemoryUtils extends InitSigar {

    /**
     * <p>
     * 获取内存信息
     * </p>
     *
     * @return {@link MemoryDomain}
     * @throws SigarException Sigar异常

     */
    public static MemoryDomain getMemoryInfo() throws SigarException {
        Mem mem = SIGAR.getMem();
        Swap swap = SIGAR.getSwap();
        MemoryDomain.MenDomain menDomain = MemoryDomain.MenDomain.builder()
                .memTotal(mem.getTotal())
                // 实际内存使用量
                .memUsed(mem.getActualUsed())
                // 实际内存剩余量
                .memFree(mem.getActualFree())
                // 物理内存使用率
                .menUsedPercent(mem.getUsedPercent() / 100D)
                .build();
        MemoryDomain.SwapDomain swapDomain = MemoryDomain.SwapDomain.builder()
                // 交换区总量
                .swapTotal(swap.getTotal())
                // 交换区使用量
                .swapUsed(swap.getUsed())
                // 交换区剩余量
                .swapFree(swap.getFree())
                // 交换区使用率
                .swapUsedPercent((double) swap.getUsed() / (double) swap.getTotal())
                .build();
        return MemoryDomain.builder().menDomain(menDomain).swapDomain(swapDomain).build();
    }
}
