package com.lyzhi.monitor.common.exception;

/**
 * 错误的配置参数异常
 *
 */
public class ErrorConfigParamException extends MonitoringUniversalException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4146067533755697316L;

    public ErrorConfigParamException() {
        super();
    }

    public ErrorConfigParamException(String message) {
        super(message);
    }
}
