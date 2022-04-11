package com.lyzhi.monitor.common.exception;

/**
 * 错误的注解参数异常
 */
public class BadAnnotateParamException extends MonitoringUniversalException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1628816165436676764L;

    public BadAnnotateParamException() {
        super();
    }

    public BadAnnotateParamException(String message) {
        super(message);
    }

}
