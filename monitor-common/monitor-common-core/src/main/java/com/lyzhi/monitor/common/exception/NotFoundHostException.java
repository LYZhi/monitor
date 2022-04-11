package com.lyzhi.monitor.common.exception;

/**
 * 找不到主机异常
 *
 */
public class NotFoundHostException extends MonitoringUniversalException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3983006251850390541L;

    public NotFoundHostException() {
        super();
    }

    public NotFoundHostException(String message) {
        super(message);
    }

}
