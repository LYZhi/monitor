package com.lyzhi.monitor.client.core;

import cn.hutool.core.lang.Console;
import com.google.common.base.Charsets;
import com.lyzhi.monitor.common.constant.AlarmLevelEnums;
import com.lyzhi.monitor.common.constant.MonitorTypeEnums;
import com.lyzhi.monitor.common.constant.ThreadTypeEnums;
import com.lyzhi.monitor.common.domain.Alarm;
import com.lyzhi.monitor.common.domain.Result;
import org.junit.Test;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试监控客户端入口类
 * </p>
 */
public class MonitorTest {

    /**
     * <p>
     * 测试发送告警信息
     * </p>
     */
    @Test
    public void testSendAlarm() {
        // 开启监控
        Monitor.start();
        // 业务埋点监控：定时监控业务运行情况
        ScheduledExecutorService service = Monitor.buryingPoint(() -> {
            // 假如发现了业务异常，用下面的代码发送告警
            Alarm alarm = new Alarm();
            alarm.setAlarmLevel(AlarmLevelEnums.ERROR);
            alarm.setTitle("业务埋点监控");
            alarm.setTest(false);
            alarm.setCharset(Charsets.UTF_8);
            alarm.setMsg("测试普通maven程序业务埋点监控！");
            // alarm.setCode("001");
            alarm.setMonitorType(MonitorTypeEnums.CUSTOM);
            Result result = Monitor.sendAlarm(alarm);
            System.out.println("发送业务告警结果：" + result.toJsonString());
        }, 0, 1, TimeUnit.SECONDS, ThreadTypeEnums.IO_INTENSIVE_THREAD);


//        service.shutdown();

        // 防止主线程退出（测试代码才需要）
        while (true) {
        }

    }
}
