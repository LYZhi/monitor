package com.lyzhi.monitor.common.exception;

/**
 * 找不到用户异常
 *
 */
public class NotFoundUserException extends MonitoringUniversalException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 403861260545255130L;

    public NotFoundUserException() {
        super();
    }

    public NotFoundUserException(String message) {
        super(message);
    }
}
