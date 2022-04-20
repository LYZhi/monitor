package com.lyzhi.monitor.client.core.thread;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.lyzhi.monitor.common.dto.HeartbeatPackage;
import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.client.core.constant.UrlConstants;
import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.client.core.core.Sender;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.SigarException;

import java.io.IOException;

/**
 * <p>
 * 心跳线程
 * </p>
 *
 * @author 皮锋
 * @custom.date 2020年3月5日 下午2:50:46
 */
@Slf4j
public class HeartbeatThread implements Runnable {

    /**
     * <p>
     * 构建+发送心跳包
     * </p>
     *
     * @author 皮锋
     * @custom.date 2020/4/9 17:32
     */
    @Override
    public void run() {
        // 计时器
        TimeInterval timer = DateUtil.timer();
        try {
            // 构建心跳数据包
            HeartbeatPackage heartbeatPackage = new PackageConstructor().structureHeartbeatPackage();
            // 发送请求
            String result = Sender.send(UrlConstants.HEARTBEAT_URL, heartbeatPackage.toJsonString());
            log.debug("心跳包响应消息：{}", result);
        } catch (IOException e) {
            log.error("IO异常！", e);
        } catch (NetException e) {
            log.error("获取网络信息异常！", e);
        } catch (SigarException e) {
            log.error("Sigar异常！", e);
        } catch (Exception e) {
            log.error("其它异常！", e);
        } finally {
            // 时间差（毫秒）
            String betweenDay = timer.intervalPretty();
            // 临界值
            int criticalValue = 5;
            if (timer.intervalSecond() > criticalValue) {
                log.warn("构建+发送心跳包耗时：{}", betweenDay);
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("构建+发送心跳包耗时：{}", betweenDay);
                }
            }
        }
    }

}
