package com.lyzhi.monitor.common.util;

import cn.hutool.core.io.unit.DataUnit;

import java.text.DecimalFormat;

/**
 * <p>
 * 数据大小工具类
 * </p>
 *
 */
public class DataSizeUtil {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *

     */
    private DataSizeUtil() {
    }

    /**
     * <p>
     * 可读的数据大小
     * </p>
     *
     * @param size double类型大小
     * @return 大小

     */
    public static String format(double size) {
        if (size <= 0) {
            return "0";
        }
        int digitGroups = Math.min(DataUnit.UNIT_NAMES.length - 1, (int) (Math.log10(size) / Math.log10(1024)));
        return new DecimalFormat("#,##0.##")
                .format(size / Math.pow(1024, digitGroups)) + " " + DataUnit.UNIT_NAMES[digitGroups];
    }

}
