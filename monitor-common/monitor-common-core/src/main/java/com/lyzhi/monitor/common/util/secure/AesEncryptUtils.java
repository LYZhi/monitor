package com.lyzhi.monitor.common.util.secure;

import cn.hutool.crypto.SecureUtil;
import com.lyzhi.monitor.common.init.InitSecure;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * <p>
 * AES加解密工具类
 * </p>
 *
 */
public class AesEncryptUtils extends InitSecure {

    /**
     * <p>
     * 字符串AES加密
     * </p>
     *
     * @param str     需要加密的字符串
     * @param charset 字符集
     * @return 加密后的字符串

     */
    public static String encrypt(String str, Charset charset) {
        byte[] key = Base64.getDecoder().decode(SECRET_KEY_AES);
        return SecureUtil.aes(key).encryptBase64(str, charset);
    }

    /**
     * <p>
     * 字节数组AES加密
     * </p>
     *
     * @param arry 需要加密的字节数组
     * @return 加密后的字符串

     */
    public static String encrypt(byte[] arry) {
        byte[] key = Base64.getDecoder().decode(SECRET_KEY_AES);
        return SecureUtil.aes(key).encryptBase64(arry);
    }

    /**
     * <p>
     * 字符串AES解密
     * </p>
     *
     * @param str     需要解密的字符串
     * @param charset 字符集
     * @return 解密后的字符串

     */
    public static String decrypt(String str, Charset charset) {
        byte[] key = Base64.getDecoder().decode(SECRET_KEY_AES);
        return SecureUtil.aes(key).decryptStr(str, charset);
    }

    /**
     * <p>
     * 字符串AES解密
     * </p>
     *
     * @param str 需要解密的字符串
     * @return 解密后的字节数组

     */
    public static byte[] decrypt(String str) {
        byte[] key = Base64.getDecoder().decode(SECRET_KEY_AES);
        return SecureUtil.aes(key).decrypt(str);
    }

}
