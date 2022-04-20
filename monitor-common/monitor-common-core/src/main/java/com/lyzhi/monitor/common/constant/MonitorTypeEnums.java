package com.lyzhi.monitor.common.constant;

/**
 * <p>
 * 监控类型
 * </p>
 *
 */
public enum MonitorTypeEnums {

    /**
     * 数据库
     */
    DATABASE,

    /**
     * 服务器
     */
    SERVER,

    /**
     * 网络
     */
    NET,

    /**
     * TCP服务
     */
    TCP4SERVICE,

    /**
     * HTTP服务
     */
    HTTP4SERVICE,

    /**
     * docker
     */
    DOCKER,

    /**
     * 应用实例
     */
    INSTANCE,

    /**
     * 自定义，如果是自己的业务监控，设置此类型
     */
    CUSTOM

}
