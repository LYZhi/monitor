package com.lyzhi.monitor.common.init;

import oshi.SystemInfo;

/**
 * <p>
 * 初始化oshi
 * </p>
 *
 */
public class InitOshi {

    /**
     * 初始化oshi，并创建SystemInfo对象
     */
    public static final SystemInfo SYSTEM_INFO = new SystemInfo();
}