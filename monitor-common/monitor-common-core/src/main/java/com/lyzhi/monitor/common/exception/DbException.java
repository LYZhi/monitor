package com.lyzhi.monitor.common.exception;

/**
 * <p>
 * 自定义数据库异常
 * </p>
 *
 */
public class DbException extends MonitoringUniversalException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6047087509207781738L;

    public DbException() {
        super();
    }

    public DbException(String message) {
        super(message);
    }

}
