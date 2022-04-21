package com.lyzhi.monitor.client.core.scheduler;

import com.lyzhi.monitor.common.threadpool.ThreadShutdownHook;
import com.lyzhi.monitor.common.util.server.ProcessorsUtils;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import com.lyzhi.monitor.client.core.thread.HeartbeatThread;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 心跳任务调度器
 * </p>
 *
 */
public class HeartbeatTaskScheduler {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     *
     */
    private HeartbeatTaskScheduler() {
    }

    /**
     * <p>
     * 延时35秒后定时发送心跳包，发送心跳包的频率一般为监控配置文件中配置的心跳频率，如果监控配置文件中没配置心跳频率，
     * 则由类{@link ConfigLoader}提供默认心跳频率。
     * </p>
     *
     *
     */
    public static void run() {
        final ScheduledExecutorService seService = new ScheduledThreadPoolExecutor(
                // 线程数 = Ncpu /（1 - 阻塞系数），IO密集型阻塞系数相对较大
                (int) (ProcessorsUtils.getAvailableProcessors() / (1 - 0.8)),
                new BasicThreadFactory.Builder()
                        // 设置线程名
                        .namingPattern("phoenix-heartbeat-pool-thread-%d")
                        // 设置为守护线程
                        .daemon(true)
                        .build());
        // 心跳频率
        long rate = ConfigLoader.MONITORING_PROPERTIES.getHeartbeatProperties().getRate();
        seService.scheduleAtFixedRate(new HeartbeatThread(), 35, rate, TimeUnit.SECONDS);
        // 关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(() -> new ThreadShutdownHook().shutdownGracefully(seService, "phoenix-heartbeat-pool-thread")));
    }

}
