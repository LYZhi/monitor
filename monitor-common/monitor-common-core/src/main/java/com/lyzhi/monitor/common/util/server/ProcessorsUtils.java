package com.lyzhi.monitor.common.util.server;

/**
 * 处理器工具类
 */
public class ProcessorsUtils {

    /**
     * 私有化构造方法
     */
    private ProcessorsUtils() {
    }

    /**
     * 获取系统可用的处理器核心数
     *
     * @return 系统可用的处理器核心数
     */
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

}
