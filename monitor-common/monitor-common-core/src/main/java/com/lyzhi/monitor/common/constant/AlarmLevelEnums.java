package com.lyzhi.monitor.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * 告警级别
 */
public enum AlarmLevelEnums {

    /**
     * 消息
     */
    INFO,

    /**
     * 警告
     */
    WARN,

    /**
     * 错误
     */
    ERROR,

    /**
     * 严重
     */
    FATAL;

    /**
     * <p>
     * 判断是否告警，当 “当前的告警级别” 大于等于 “配置的告警级别” 时，返回true
     * </p>
     *
     * @param configAlarmLevel 配置的告警级别
     * @param alarmLevel       当前的告警级别
     * @return boolean
     *
     */
    public static boolean isAlarm(AlarmLevelEnums configAlarmLevel, AlarmLevelEnums alarmLevel) {
        // INFO
        if (AlarmLevelEnums.INFO == configAlarmLevel) {
            return true;
        }
        // WARN
        if (AlarmLevelEnums.WARN == configAlarmLevel) {
            // WARN、ERROR、FATAL
            if (AlarmLevelEnums.WARN == alarmLevel || AlarmLevelEnums.ERROR == alarmLevel || AlarmLevelEnums.FATAL == alarmLevel) {
                return true;
            }
        }
        // ERROR
        if (AlarmLevelEnums.ERROR == configAlarmLevel) {
            // ERROR、FATAL
            if (AlarmLevelEnums.ERROR == alarmLevel || AlarmLevelEnums.FATAL == alarmLevel) {
                return true;
            }
        }
        // FATAL
        if (AlarmLevelEnums.FATAL == configAlarmLevel) {
            // FATAL
            return AlarmLevelEnums.FATAL == alarmLevel;
        }
        return false;
    }

    /**
     * <p>
     * 告警级别字符串转告警级别枚举
     * </p>
     *
     * @param alarmLevelStr 告警级别字符串
     * @return 告警级别枚举
     *
     */
    public static AlarmLevelEnums str2Enum(String alarmLevelStr) {
        // 消息
        if (StringUtils.equalsIgnoreCase(AlarmLevelEnums.INFO.name(), alarmLevelStr)) {
            return AlarmLevelEnums.INFO;
        }
        // 警告
        if (StringUtils.equalsIgnoreCase(AlarmLevelEnums.WARN.name(), alarmLevelStr)) {
            return AlarmLevelEnums.WARN;
        }
        // 错误
        if (StringUtils.equalsIgnoreCase(AlarmLevelEnums.ERROR.name(), alarmLevelStr)) {
            return AlarmLevelEnums.ERROR;
        }
        // 严重
        if (StringUtils.equalsIgnoreCase(AlarmLevelEnums.FATAL.name(), alarmLevelStr)) {
            return AlarmLevelEnums.FATAL;
        }
        return null;
    }


}
