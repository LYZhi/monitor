package com.lyzhi.monitor.common.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * <p>
 * MD5工具类
 * </p>
 *
 */
@Slf4j
public final class Md5Utils {

    /**
     * 加密算法
     */
    private static final String ALGORITHM = "MD5";

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *

     */
    private Md5Utils() {
    }

    /**
     * <p>
     * 获取32位md5校验码
     * </p>
     *
     * @param encryptStr 字符串
     * @return 32位md5校验码

     */
    @SneakyThrows
    public static String encrypt32(String encryptStr) {
        MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
        byte[] md5Bytes = md5.digest(encryptStr.getBytes());
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * <p>
     * 获取16位md5校验码
     * </p>
     *
     * @param encryptStr 字符串
     * @return 16位md5校验码

     */
    public static String encrypt16(String encryptStr) {
        return encrypt32(encryptStr).substring(8, 24);
    }

    /**
     * <p>
     * 获取md5校验码
     * </p>
     *
     * @param encryptStr 字符串
     * @return md5校验码

     */
    public static String encrypt(String encryptStr) {
        // 默认使用16位md5校验码
        return encrypt16(encryptStr);
    }

}
