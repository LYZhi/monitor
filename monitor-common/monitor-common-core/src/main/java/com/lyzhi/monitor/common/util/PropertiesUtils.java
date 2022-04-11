package com.lyzhi.monitor.common.util;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * <p>
 * java读取.properties文件
 * </p>
 *
 */
@Slf4j
public final class PropertiesUtils {

    /**
     * <p>
     * 屏蔽公有构造方法
     * </p>
     *
     */
    private PropertiesUtils() {
    }

    /**
     * <p>
     * 把资源属性文件（properties）加载到缓存中
     * </p>
     *
     * @param filePath 文件路径
     * @return {@link Properties}
     * @throws IOException IO异常
     *
     */
    public static Properties loadProperties(final String filePath) throws IOException {
        try {
            // 属性集合对象
            Properties properties = new Properties();
            // 获取路径并转换成流
            @Cleanup
            InputStream path = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
            assert path != null;
            @Cleanup
            InputStreamReader inputStreamReader = new InputStreamReader(path, StandardCharsets.UTF_8);
            @Cleanup
            BufferedReader bf = new BufferedReader(inputStreamReader);
            // 将属性文件流装载到Properties对象中
            properties.load(bf);
            return properties;
        } catch (IOException e) {
            log.error("读properties属性文件异常！", e);
            throw new IOException(e);
        }
    }

}