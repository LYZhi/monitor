package com.lyzhi.monitor.common.constant.sql;

/**
 * <p>
 * MySQL数据库sql语句
 * </p>
 *
 */
public final class MySql {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *

     */
    private MySql() {
    }

    /**
     * 检查连接
     */
    public static final String CHECK_CONN = "SELECT 1 FROM DUAL";

    /**
     * 会话列表
     */
    public static final String SESSION_LIST = "show full processlist";

    /**
     * 结束会话
     */
    public static final String KILL_SESSION = "kill ?";

}
