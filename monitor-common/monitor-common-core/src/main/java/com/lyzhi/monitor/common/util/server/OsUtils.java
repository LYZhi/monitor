package com.lyzhi.monitor.common.util.server;

import com.lyzhi.monitor.common.domain.server.OsDomain;
import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;

/**
 * <p>
 * 操作系统工具类
 * </p>
 *
 */
public final class OsUtils {

    /**
     * 系统属性
     */
    private static final Properties PROPS = System.getProperties();

    /**
     * 环境属性
     */
    private static final Map<String, String> ENVS = System.getenv();

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     */
    private OsUtils() {
    }

    /**
     * <p>
     * 判断操作系统是不是Windows
     * </p>
     *
     * @return boolean
     *
     */
    public static boolean isWindowsOs() {
        boolean isWindowsOs = false;
        String osName = System.getProperty("os.name");
        if (StringUtils.containsIgnoreCase(osName, "windows")) {
            isWindowsOs = true;
        }
        return isWindowsOs;
    }

    /**
     * <p>
     * 获取操作系统信息
     * </p>
     *
     * @return {@link OsDomain}
     *
     */
    public static OsDomain getOsInfo() {
        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = cal.getTimeZone();
        return new OsDomain()
                .setOsName(PROPS.getProperty("os.name"))
                .setOsArch(PROPS.getProperty("os.arch"))
                .setOsVersion(PROPS.getProperty("os.version"))
                .setUserName(PROPS.getProperty("user.name"))
                .setUserHome(PROPS.getProperty("user.home"))
                .setOsTimeZone(timeZone.getDisplayName())
                .setComputerName(getComputerName());
    }

    /**
     * <p>
     * 获取计算机名
     * </p>
     *
     * @return 计算机名
     *
     */
    public static String getComputerName() {
        // Windows操作系统
        if (isWindowsOs()) {
            return ENVS.get("COMPUTERNAME");
        } else {
            try {
                return InetAddress.getLocalHost().getHostName();
            } catch (Exception e) {
                return "UnknownHost";
            }
        }
    }

}

	