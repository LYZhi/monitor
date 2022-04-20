package com.lyzhi.monitor.common.util.server;

/**
 * <p>
 * 处理器工具类
 * </p>
 *
 */
public class ProcessorsUtils {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *

     */
    private ProcessorsUtils() {
    }

    /**
     * <p>
     * 获取系统可用的处理器核心数
     * </p>
     *
     * @return 系统可用的处理器核心数

     */
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

}
