package com.lyzhi.monitor.common.exception;

/**
 * 找不到配置文件异常
 */
public class NotFoundConfigFileException extends MonitoringUniversalException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -792375440969840360L;

    public NotFoundConfigFileException() {
        super();
    }

    public NotFoundConfigFileException(String message) {
        super(message);
    }

}
