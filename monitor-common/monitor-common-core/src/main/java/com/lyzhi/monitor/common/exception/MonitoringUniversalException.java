package com.lyzhi.monitor.common.exception;

/**
 * <p>
 * 监控平台通用异常
 * </p>
 *
 */
public class MonitoringUniversalException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6220209419798968058L;

    public MonitoringUniversalException() {
        super();
    }

    public MonitoringUniversalException(String message) {
        super(message);
    }

}
