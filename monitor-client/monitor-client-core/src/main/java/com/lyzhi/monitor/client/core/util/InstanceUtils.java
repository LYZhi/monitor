package com.lyzhi.monitor.client.core.util;

import com.lyzhi.monitor.common.exception.NetException;
import com.lyzhi.monitor.common.util.Md5Utils;
import com.lyzhi.monitor.common.util.server.NetUtils;
import com.lyzhi.monitor.client.core.core.ConfigLoader;
import org.hyperic.sigar.SigarException;

/**
 * <p>
 * 应用实例工具类
 * </p>
 *
 */
public class InstanceUtils {

    /**
     * <p>
     * 应用实例ID
     * </p>
     * ThreadLocal是JDK包提供的，它提供线程本地变量，如果创建一个ThreadLocal变量，
     * 那么访问这个变量的每个线程都会有这个变量的一个副本，在实际多线程操作的时候，
     * 操作的是自己本地内存中的变量，从而规避了线程安全问题。
     */
    private static final ThreadLocal<String> INSTANCE_ID_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     *
     */
    private InstanceUtils() {
    }

    /**
     * <p>
     * 获取应用实例ID
     * </p>
     *
     * @return 应用实例ID
     * @throws NetException   获取网络信息异常
     * @throws SigarException Sigar异常
     *
     */
    public static String getInstanceId() throws NetException, SigarException {
        String instanceId = INSTANCE_ID_THREAD_LOCAL.get();
        if (instanceId != null) {
            return instanceId;
        }
        String mac = NetUtils.getLocalMac();
        // 如果配置了服务器IP，用配置的，如果没有配置服务器IP，则自己获取
        String ip = ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp() == null ? NetUtils.getLocalIp() : ConfigLoader.MONITORING_PROPERTIES.getServerInfoProperties().getIp();
        // 实例次序（不能重复）
        int order = ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceOrder();
        // 实例名称
        String instanceName = ConfigLoader.MONITORING_PROPERTIES.getOwnProperties().getInstanceName();
        // 实例ID
        instanceId = Md5Utils.encrypt(mac + ip + order + instanceName);
        INSTANCE_ID_THREAD_LOCAL.set(instanceId);
        return instanceId;
    }

    /**
     * <p>
     * 回收本地线程
     * </p>
     *
     *
     */
    public static void remove() {
        INSTANCE_ID_THREAD_LOCAL.remove();
    }

}
