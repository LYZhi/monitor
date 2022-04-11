package com.lyzhi.monitor.client.core.thread;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.lyzhi.monitor.client.core.constant.UrlConstants;
import com.lyzhi.monitor.client.core.core.PackageConstructor;
import com.lyzhi.monitor.client.core.core.Sender;
import com.lyzhi.monitor.common.dto.ServerPackage;
import com.lyzhi.monitor.common.exception.NetException;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.SigarException;

import java.io.IOException;

/**
 * <p>
 * 发送服务器信息线程
 * </p>
 */
@Slf4j
public class ServerThread implements Runnable {

    /**
     * <p>
     * 构建+发送服务器信息包
     * </p>
     */
    @Override
    public void run() {
        // 计时器
        TimeInterval timer = DateUtil.timer();
        try {
            // 构建服务器数据包
            ServerPackage serverPackage = new PackageConstructor().structureServerPackage();
            // 发送请求
            String result = Sender.send(UrlConstants.SERVER_URL, serverPackage.toJsonString());
            log.debug("服务器信息包响应消息：{}", result);
        } catch (IOException e) {
            log.error("IO异常！", e);
        } catch (SigarException e) {
            log.error("Sigar异常！", e);
        } catch (NetException e) {
            log.error("获取网络信息异常！", e);
        } catch (Exception e) {
            log.error("其它异常！", e);
        } finally {
            // 时间差（毫秒）
            String betweenDay = timer.intervalPretty();
            // 临界值
            int criticalValue = 5;
            if (timer.intervalSecond() > criticalValue) {
                log.warn("构建+发送服务器信息包耗时：{}", betweenDay);
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("构建+发送服务器信息包耗时：{}", betweenDay);
                }
            }
        }
    }

}
