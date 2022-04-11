package com.lyzhi.monitor.server.config;

import com.lyzhi.monitor.common.threadpool.ThreadPool;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * <p>
 * 异步配置
 * </p>
 *
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    /**
     * <p>
     * 异步方法调用时要使用的执行器实例。
     * </p>
     *
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        // IO密集型的线程池
        return ThreadPool.COMMON_IO_INTENSIVE_THREAD_POOL;
    }

}
