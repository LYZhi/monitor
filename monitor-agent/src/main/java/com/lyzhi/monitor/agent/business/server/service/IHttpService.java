package com.lyzhi.monitor.agent.business.server.service;

import com.lyzhi.monitor.common.dto.BaseResponsePackage;

/**
 * <p>
 * 跟服务端相关的HTTP服务接口
 * </p>
 *
 */
public interface IHttpService {

    /**
     * <p>
     * 发送HTTP POST请求。
     * </p>
     * 1.加密数据；<br>
     * 2.把加密后的数据封装到密文数据包；<br>
     * 3.发送http请求；<br>
     * 4.获取响应密文数据包；<br>
     * 5.解密密文数据包；<br>
     * 6.把密文数据包转换成基础响应包。<br>
     *
     * @param json 请求参数
     * @param url  请求地址
     * @return {@link BaseResponsePackage}
     * @throws Exception 所有异常
     *
     */
    BaseResponsePackage sendHttpPost(String json, String url) throws Exception;
}
