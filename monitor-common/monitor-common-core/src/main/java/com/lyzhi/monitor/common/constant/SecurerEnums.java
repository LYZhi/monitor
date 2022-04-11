package com.lyzhi.monitor.common.constant;


import com.lyzhi.monitor.common.inf.ISecurer;
import com.lyzhi.monitor.common.util.secure.AesEncryptUtils;
import com.lyzhi.monitor.common.util.secure.DesEncryptUtils;
import com.lyzhi.monitor.common.util.secure.Sm4EncryptUtils;

import java.nio.charset.Charset;

/**
 * <p>
 * 加解密类型枚举
 * </p>
 *
 */
public enum SecurerEnums implements ISecurer {

    /**
     * DES加解密
     */
    DES {
        @Override
        public String encrypt(String str, Charset charset) {
            return DesEncryptUtils.encrypt(str, charset);
        }

        @Override
        public String encrypt(byte[] arry) {
            return DesEncryptUtils.encrypt(arry);
        }

        @Override
        public String decrypt(String str, Charset charset) {
            return DesEncryptUtils.decrypt(str, charset);
        }

        @Override
        public byte[] decrypt(String str) {
            return DesEncryptUtils.decrypt(str);
        }
    },

    /**
     * AES加解密
     */
    AES {
        @Override
        public String encrypt(String str, Charset charset) {
            return AesEncryptUtils.encrypt(str, charset);
        }

        @Override
        public String encrypt(byte[] arry) {
            return AesEncryptUtils.encrypt(arry);
        }

        @Override
        public String decrypt(String str, Charset charset) {
            return AesEncryptUtils.decrypt(str, charset);
        }

        @Override
        public byte[] decrypt(String str) {
            return AesEncryptUtils.decrypt(str);
        }
    },

    /**
     * 国密SM4加解密
     */
    SM4 {
        @Override
        public String encrypt(String str, Charset charset) {
            return Sm4EncryptUtils.encrypt(str, charset);
        }

        @Override
        public String encrypt(byte[] arry) {
            return Sm4EncryptUtils.encrypt(arry);
        }

        @Override
        public String decrypt(String str, Charset charset) {
            return Sm4EncryptUtils.decrypt(str, charset);
        }

        @Override
        public byte[] decrypt(String str) {
            return Sm4EncryptUtils.decrypt(str);
        }
    }
}
