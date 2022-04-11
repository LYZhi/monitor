package com.lyzhi.monitor.client.core;

import com.alibaba.fastjson.JSON;
import com.lyzhi.monitor.client.core.constant.UrlConstants;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.client.core.core.Sender;
import com.lyzhi.monitor.client.core.scheduler.HeartbeatTaskScheduler;
import com.lyzhi.monitor.client.core.scheduler.JvmTaskScheduler;
import com.lyzhi.monitor.client.core.scheduler.ServerTaskScheduler;
import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.domain.Result;
import com.lyzhi.monitor.common.dto.AlarmPackage;
import com.lyzhi.monitor.common.dto.BaseResponsePackage;
import com.lyzhi.monitor.common.exception.ErrorConfigParamException;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.exception.NotFoundConfigFileException;
import com.lyzhi.monitor.common.exception.NotFoundConfigParamException;
import com.lyzhi.monitor.common.init.InitBanner;
import com.lyzhi.monitor.common.property.client.MonitoringProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.SigarException;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 监控客户端入口类
 */
@Slf4j
public class Monitor {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     */
    private Monitor() {
    }

    /**
     * <p>
     * 开启监控
     * </p>
     *
     * @return {@link MonitoringProperties}
     */
    @SneakyThrows
    public static MonitoringProperties start() {
        return run(null, null);
    }

    /**
     * <p>
     * 开启监控，自定义配置文件路径和名字
     * </p>
     *
     * @param configPath 配置文件路径
     * @param configName 配置文件名字
     * @return {@link MonitoringProperties}
     */
    @SneakyThrows
    public static MonitoringProperties start(final String configPath, final String configName) {
        return run(configPath, configName);
    }

    /**
     * <p>
     * 运行监控
     * </p>
     *
     * @param configPath 配置文件路径
     * @param configName 配置文件名字
     * @return {@link MonitoringProperties}
     * @throws NotFoundConfigFileException  找不到配置文件异常
     * @throws ErrorConfigParamException    错误的配置参数异常
     * @throws NotFoundConfigParamException 找不到配置参数异常
     */
    private static MonitoringProperties run(final String configPath, final String configName)
            throws NotFoundConfigFileException, ErrorConfigParamException, NotFoundConfigParamException {
        // 1.打印banner信息
        InitBanner.declare();
        // 2.加载配置信息
        MonitoringProperties monitoringProperties = ConfigLoader.load(configPath, configName);
        // 3.开始定时发送心跳包
        HeartbeatTaskScheduler.run();
        // 4.开始定时发送服务器信息包
        ServerTaskScheduler.run();
        // 5.开始定时发送Java虚拟机信息包
        JvmTaskScheduler.run();
        // 返回监控属性
        return monitoringProperties;
    }

    /**
     * <p>
     * 发送告警
     * </p>
     *
     * @param alarm 告警信息
     * @return {@link Result}
     */
    public static Result sendAlarm(Alarm alarm) {
        try {
            // 构造告警数据包
            AlarmPackage alarmPackage = new PackageConstructor().structureAlarmPackage(alarm);
            String result = Sender.send(UrlConstants.ALARM_URL, alarmPackage.toJsonString());
            BaseResponsePackage baseResponsePackage = JSON.parseObject(result, BaseResponsePackage.class);
            return baseResponsePackage.getResult();
        } catch (IOException | NetException | SigarException e) {
            log.error("监控程序发送告警信息异常！", e);
            return Result.builder().isSuccess(false).msg(e.getMessage()).build();
        }
    }

    /**
     * <p>
     * 业务埋点监控：定时监控业务运行情况
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
//    public static ScheduledExecutorService buryingPoint(Runnable command, long initialDelay, long period, TimeUnit unit, ThreadTypeEnums threadTypeEnum) {
//        return BusinessBuryingPointScheduler.run(command, initialDelay, period, unit, threadTypeEnum);
//    }

}
