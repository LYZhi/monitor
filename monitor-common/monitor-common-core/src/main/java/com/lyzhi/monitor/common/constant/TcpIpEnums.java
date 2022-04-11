package com.lyzhi.monitor.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * TCP/IP协议簇枚举
 * </p>
 *
 */
public enum TcpIpEnums {

    /**
     * TCP
     */
    TCP;

    /**
     * <p>
     * TCP/IP协议簇字符串转枚举
     * </p>
     *
     * @param tcpIpStr TCP/IP协议簇字符串
     * @return TCP/IP协议簇枚举
     *
     */
    public static TcpIpEnums str2Enum(String tcpIpStr) {
        // TCP
        if (StringUtils.equalsIgnoreCase(TcpIpEnums.TCP.name(), tcpIpStr)) {
            return TcpIpEnums.TCP;
        }
        return null;
    }

}