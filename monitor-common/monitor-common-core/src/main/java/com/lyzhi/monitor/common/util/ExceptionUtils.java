package com.lyzhi.monitor.common.util;

/**
 * <p>
 * 异常处理工具类
 * </p>
 *
 */
public class ExceptionUtils {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *

     */
    private ExceptionUtils() {
    }

    /**
     * <p>
     * 转换异常信息为字符串
     * </p>
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     * @return 异常信息字符串

     */
    public static String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuilder builder = new StringBuilder();
        for (StackTraceElement stet : elements) {
            builder.append(stet).append("\n");
        }
        return exceptionName + ":" + exceptionMessage + "\n" + builder.toString();
    }

}
