package com.lyzhi.monitor.common.exception;

/**
 * <p>
 * 找不到主机异常
 * </p>
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
