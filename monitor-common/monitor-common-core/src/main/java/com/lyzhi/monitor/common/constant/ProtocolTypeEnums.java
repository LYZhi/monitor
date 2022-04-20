package com.lyzhi.monitor.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 协议类型
 * </p>
 *
 */
public enum ProtocolTypeEnums {

    /**
     * HTTP协议
     */
    HTTP;

    /**
     * <p>
     * 协议类型字符串转协议类型枚举
     * </p>
     *
     * @param protocolTypeStr 协议类型字符串
     * @return 协议类型枚举

     */
    public static ProtocolTypeEnums str2Enum(String protocolTypeStr) {
        // HTTP协议
        if (StringUtils.equalsIgnoreCase(ProtocolTypeEnums.HTTP.name(), protocolTypeStr)) {
            return ProtocolTypeEnums.HTTP;
        }
        return null;
    }

}
