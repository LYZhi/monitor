package com.lyzhi.monitor.common.web.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * <p>
 * 上下文环境工具类
 * </p>
 *
 */
public class ContextUtils {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     *
     */
    private ContextUtils() {
    }

    /**
     * <p>
     * SpringMvc下获取ServletRequestAttributes
     * </p>
     *
     * @return {@link ServletRequestAttributes}
     *
     */
    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes());
    }

    /**
     * <p>
     * SpringMvc下获取request
     * </p>
     *
     * @return {@link HttpServletRequest}
     *
     */
    public static HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    /**
     * <p>
     * SpringMvc下获取session
     * </p>
     *
     * @return {@link HttpSession}
     *
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

}
