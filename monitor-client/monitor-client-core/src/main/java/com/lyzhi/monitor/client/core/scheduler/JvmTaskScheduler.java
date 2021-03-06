package com.lyzhi.monitor.client.core.scheduler;

import com.lyzhi.monitor.common.threadpool.ThreadShutdownHook;
import com.lyzhi.monitor.common.util.server.ProcessorsUtils;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import com.lyzhi.monitor.client.core.thread.JvmThread;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 发送Java虚拟机信息任务调度器
 * </p>
 *
 */
public class JvmTaskScheduler {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     *
     */
    private JvmTaskScheduler() {
    }

    /**
     * <p>
     * 如果监控配置文件中配置了发送Java虚拟机，则延迟45秒启动定时任务，定时发送Java虚拟机包，
     * 定时任务的执行频率一般为监控配置文件中配置的Java虚拟机包发送频率，如果监控配置文件中没有配置Java虚拟机包的发送频率，
     * 则由类{@link ConfigLoader}提供默认的发送Java虚拟机频率。
     * </p>
     *
     *
     */
    public static void run() {
        // 是否发送Java虚拟机
        boolean jvmInfoEnable = ConfigLoader.MONITORING_PROPERTIES.getJvmInfoProperties().isEnable();
        if (jvmInfoEnable) {
            final ScheduledExecutorService seService = new ScheduledThreadPoolExecutor(
                    // 线程数 = Ncpu /（1 - 阻塞系数），IO密集型阻塞系数相对较大
                    (int) (ProcessorsUtils.getAvailableProcessors() / (1 - 0.8)),
                    new BasicThreadFactory.Builder()
                            // 设置线程名s
                            .namingPattern("phoenix-jvm-pool-thread-%d")
                            // 设置为守护线程
                            .daemon(true)
                            .build());
            // 发送Java虚拟机的频率
            long rate = ConfigLoader.MONITORING_PROPERTIES.getJvmInfoProperties().getRate();
            seService.scheduleAtFixedRate(new JvmThread(), 45, rate, TimeUnit.SECONDS);
            // 关闭钩子
            Runtime.getRuntime().addShutdownHook(new Thread(() -> new ThreadShutdownHook().shutdownGracefully(seService, "phoenix-jvm-pool-thread")));
        }
    }

}
