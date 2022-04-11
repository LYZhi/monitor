package com.lyzhi.monitor.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Map工具类
 * </p>
 *
 */
public class MapUtils {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     */
    private MapUtils() {
    }

    /**
     * <p>
     * 转换请求参数
     * </p>
     *
     * @param paramMap 请求参数
     * @return {@link Map}
     *
     */
    public static Map<String, String> convertParamMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<>(16);
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }

}
