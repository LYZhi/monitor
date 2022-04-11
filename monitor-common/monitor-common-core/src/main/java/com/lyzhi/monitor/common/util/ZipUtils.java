package com.lyzhi.monitor.common.util;

import cn.hutool.core.io.unit.DataSize;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 压缩工具类
 * </p>
 *
 *
 */
@Slf4j
public class ZipUtils {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     */
    private ZipUtils() {
    }

    /**
     * <p>
     * 字符串是否需要进行gzip压缩
     * </p>
     *
     * @param str 输入字符串
     * @return boolean 否需要进行gzip压缩
     *
     */
    public static boolean isNeedGzip(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        // 64KB
        long minSize = DataSize.ofKilobytes(64).toBytes();
        if (str.getBytes().length <= minSize) {
            return false;
        }
        if (log.isDebugEnabled()) {
            log.debug("字符串超过64KB，启用gzip！");
        }
        return true;
    }

}
