package com.lyzhi.monitor.server.config;

import com.lyzhi.monitor.common.threadpool.ThreadPool;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.Task;

/**
 * <p>
 * 调度配置
 * </p>
 *
 */
@Configuration
@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {

    /**
     * <p>
     * 回调，允许针对给定的{@link ScheduledTaskRegistrar}注册{@link TaskScheduler}和特定{@link Task}实例。
     * </p>
     *
     * @param scheduledTaskRegistrar 要配置的注册器
     *
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(ThreadPool.COMMON_IO_INTENSIVE_SCHEDULED_THREAD_POOL);
    }

}
