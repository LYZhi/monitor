package com.lyzhi.monitor.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 企业枚举
 * </p>
 *
 */
public enum EnterpriseEnums {

    /**
     * phoenix
     */
    PHOENIX;

    /**
     * <p>
     * 企业名字符串转企业名字枚举
     * </p>
     *
     * @param enterpriseStr 企业名字符串
     * @return 企业名字枚举
     *
     */
    public static EnterpriseEnums str2Enum(String enterpriseStr) {
        // phoenix
        if (StringUtils.equalsIgnoreCase(EnterpriseEnums.PHOENIX.name(), enterpriseStr)) {
            return EnterpriseEnums.PHOENIX;
        }
        return null;
    }

}
