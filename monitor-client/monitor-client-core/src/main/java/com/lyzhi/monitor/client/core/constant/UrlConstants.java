package com.lyzhi.monitor.client.core.constant;

import com.lyzhi.monitor.client.core.core.ConfigLoader;

/**
 * <p>
 * URL地址
 * </p>
 *
 */
public final class UrlConstants {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     *
     */
    private UrlConstants() {
    }

    /**
     * 服务根路径
     */
    private static final String ROOT_URI = ConfigLoader.MONITORING_PROPERTIES.getServerProperties().getUrl();

    /**
     * 心跳地址
     */
    public static final String HEARTBEAT_URL = ROOT_URI + "/heartbeat/accept-heartbeat-package";

    /**
     * 告警地址
     */
    public static final String ALARM_URL = ROOT_URI + "/alarm/accept-alarm-package";

    /**
     * 发送服务器信息地址
     */
    public static final String SERVER_URL = ROOT_URI + "/server/accept-server-package";

    /**
     * 发送Java虚拟机信息地址
     */
    public static final String JVM_URL = ROOT_URI + "/jvm/accept-jvm-package";

}
