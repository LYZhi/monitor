package com.lyzhi.monitor.web.constant;

/**
 * <p>
 * 返回给浏览器的常量
 * </p>
 *
 */
public class WebResponseConstants {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     *
     */
    private WebResponseConstants() {
    }

    /**
     * 成功
     */
    public static final String SUCCESS = "success";

    /**
     * 失败
     */
    public static final String FAIL = "fail";

    /**
     * 已经存在
     */
    public static final String EXIST = "exist";

    /**
     * 校验失败
     */
    public static final String VERIFY_FAIL = "verifyFail";

    /**
     * 刷新失败
     */
    public static final String REFRESH_FAIL = "refreshFail";

    /**
     * 必选项（必填项）为空
     */
    public static final String REQUIRED_IS_NULL = "requiredIsNull";

    /**
     * 数据完整性冲突
     */
    public static final String DATA_INTEGRITY_VIOLATION = "dataIntegrityViolation";

}
