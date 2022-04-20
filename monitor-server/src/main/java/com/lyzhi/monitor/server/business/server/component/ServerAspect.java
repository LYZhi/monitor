package com.lyzhi.monitor.server.business.server.component;

import com.lyzhi.monitor.common.dto.ServerPackage;
import com.lyzhi.monitor.common.threadpool.ThreadPool;
import com.lyzhi.monitor.server.business.server.controller.ServerController;
import com.lyzhi.monitor.server.inf.IServerMonitoringListener;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 服务器信息包切面
 * </p>
 *
 */
@Aspect
@Component
public class ServerAspect {

    /**
     * 服务器信息监听器
     */
    @Autowired
    private List<IServerMonitoringListener> serverMonitoringListeners;

    /**
     * <p>
     * 定义切入点，切入点为{@link ServerController#acceptServerPackage(ServerPackage)}这一个方法
     * </p>
     *
     *
     */
    @Pointcut("execution(public * com.lyzhi.monitor.server.business.server.controller.ServerController.acceptServerPackage(..))")
    public void tangentPoint() {
    }

    /**
     * <p>
     * 通过后置通知，调用监听器回调接口。
     * </p>
     *
     * @param joinPoint 提供对连接点上可用状态和有关状态的静态信息的反射访问。
     *
     */
    @After("tangentPoint()")
    public void wakeUp(JoinPoint joinPoint) {
        ServerPackage serverPackage = (ServerPackage) joinPoint.getArgs()[0];
        // IP地址
        String ip = serverPackage.getIp();
        // 调用监听器回调接口
        this.serverMonitoringListeners.forEach(o -> ThreadPool.COMMON_IO_INTENSIVE_THREAD_POOL.execute(() -> o.wakeUpMonitor(ip)));
    }

}
