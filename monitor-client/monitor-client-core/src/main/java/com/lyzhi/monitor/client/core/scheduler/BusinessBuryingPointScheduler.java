package com.lyzhi.monitor.client.core.scheduler;

import com.lyzhi.monitor.common.constant.ThreadTypeEnums;
import com.lyzhi.monitor.common.threadpool.ThreadPool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 业务埋点任务调度器
 * </p>
 *
 */
public class BusinessBuryingPointScheduler {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     *
     */
    private BusinessBuryingPointScheduler() {
    }

    /**
     * <p>
     * 定时运行业务埋点监控任务
     * CPU密集型需要提供更多的线程进行处理，而IO密集型则不需要过多的线程
     * </p>
     *
     * @param command        要执行的任务
     * @param initialDelay   初次埋点监控延迟的时间
     * @param period         两次埋点监控任务之间的时间间隔
     * @param unit           时间单位
     * @param threadTypeEnum 线程类型：CPU密集型、IO密集型
     * @return {@link ScheduledExecutorService}
     *
     */
    public static ScheduledExecutorService run(Runnable command, long initialDelay, long period, TimeUnit unit, ThreadTypeEnums threadTypeEnum) {
        // CPU密集型
        if (threadTypeEnum == ThreadTypeEnums.CPU_INTENSIVE_THREAD) {
            final ScheduledExecutorService seService = ThreadPool.COMMON_CPU_INTENSIVE_SCHEDULED_THREAD_POOL;
            seService.scheduleAtFixedRate(command, initialDelay, period, unit);
            return seService;
        }
        // IO密集型
        else {
            final ScheduledExecutorService seService = ThreadPool.COMMON_IO_INTENSIVE_SCHEDULED_THREAD_POOL;
            seService.scheduleAtFixedRate(command, initialDelay, period, unit);
            return seService;
        }
    }

}
