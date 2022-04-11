package com.lyzhi.monitor.common.util;


import com.liferay.portal.kernel.util.ServerDetector;
import com.lyzhi.monitor.common.constant.AppServerTypeEnums;

/**
 * <p>
 * 应用服务器工具类
 * </p>
 *
 */
public class AppServerDetectorUtils {

    /**
     * <p>
     * 构造方法私有化
     * </p>
     *
     */
    private AppServerDetectorUtils() {
    }

    public static final String JETTY_CLASS = "/org/mortbay/jetty/Server.class";

    public static final String UNDERTOW_CLASS = "/io/undertow/Undertow.class";

    public static final String NETTY_CLASS = "/reactor/netty/http/server/HttpServer.class";

    /**
     * <p>
     * 获取应用服务器枚举类型
     * </p>
     *
     * @return {@link AppServerTypeEnums}
     *
     */
    public static AppServerTypeEnums getAppServerTypeEnum() {
        if (ServerDetector.isTomcat()) {
            return AppServerTypeEnums.TOMCAT;
        }
        if (ServerDetector.isWebLogic()) {
            return AppServerTypeEnums.WEBLOGIC;
        }
        if (isUndertow()) {
            return AppServerTypeEnums.UNDERTOW;
        }
        if (isJetty()) {
            return AppServerTypeEnums.JETTY;
        }
        if (isNetty()) {
            return AppServerTypeEnums.NETTY;
        }
        return AppServerTypeEnums.UNKNOWN;
    }

    /**
     * <p>
     * 是不是Jetty服务器
     * </p>
     *
     * @return 是 或者 否
     *
     */
    private static boolean isJetty() {
        Class<?> c = AppServerDetectorUtils.class;
        return c.getResource(JETTY_CLASS) != null;
    }

    /**
     * <p>
     * 是不是Undertow服务器
     * </p>
     *
     * @return 是 或者 否
     *
     */
    private static boolean isUndertow() {
        Class<?> c = AppServerDetectorUtils.class;
        return c.getResource(UNDERTOW_CLASS) != null;
    }

    /**
     * <p>
     * 是不是Netty服务器
     * </p>
     *
     * @return 是 或者 否
     *
     */
    private static boolean isNetty() {
        Class<?> c = AppServerDetectorUtils.class;
        return c.getResource(NETTY_CLASS) != null;
    }

}
