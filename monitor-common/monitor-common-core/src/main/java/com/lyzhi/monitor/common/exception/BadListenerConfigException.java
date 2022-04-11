package com.lyzhi.monitor.common.exception;

/**
 * 错误的监听器配置异常
 */
public class BadListenerConfigException extends MonitoringUniversalException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1672157366010494089L;

    public BadListenerConfigException() {
        super();
    }

    public BadListenerConfigException(String message) {
        super(message);
    }
}
