package com.lyzhi.monitor.common.exception;

/**
 * 自定义获取网络信息异常
 *
 */
public class NetException extends MonitoringUniversalException {

    private static final long serialVersionUID = -491704241199412819L;

    public NetException() {
        super();
    }

    public NetException(String message) {
        super(message);
    }
}
