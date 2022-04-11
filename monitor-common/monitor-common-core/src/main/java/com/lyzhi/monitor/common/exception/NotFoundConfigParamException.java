package com.lyzhi.monitor.common.exception;

/**
 * 找不到配置参数异常
 *
 */
public class NotFoundConfigParamException extends MonitoringUniversalException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6546543050835301134L;

    public NotFoundConfigParamException() {
        super();
    }

    public NotFoundConfigParamException(String message) {
        super(message);
    }

}
