package com.lyzhi.monitor.common.constant;

/**
 * 告警原因
 */
public enum AlarmReasonEnums {

    /**
     * 正常变异常
     */
    NORMAL_2_ABNORMAL,

    /**
     * 异常变正常
     */
    ABNORMAL_2_NORMAL,

    /**
     * 发现（应用程序、服务器、...）
     */
    DISCOVERY,

    /**
     * 忽略
     */
    IGNORE

}
