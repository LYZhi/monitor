package com.lyzhi.monitor.common.init;

import cn.hutool.core.lang.Console;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 初始化项目banner
 * </p>
 *
 */
@Slf4j
public class InitBanner {

    static {
        InitBanner.printBanner();
    }

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *

     */
    private InitBanner() {
    }

    /**
     * <p>
     * 加载“banner.txt”文件
     * </p>
     *
     * @return “banner.txt”文件字符串
     * @throws IOException IO异常

     */
    private static String loadBanner() throws IOException {
        @Cleanup
        InputStream path = Thread.currentThread().getContextClassLoader().getResourceAsStream("banner-monitoring.txt");
        assert path != null;
        return IOUtils.toString(path, StandardCharsets.UTF_8);
    }

    /**
     * <p>
     * 打印banner
     * </p>
     *

     */
    public static void printBanner() {
        try {
            // 加载
            String banner = loadBanner();
            // 打印banner
            Console.log(banner);
        } catch (IOException e) {
            log.error("控制台打印banner异常！", e);
        }
    }

    /**
     * <p>
     * 打印banner成功
     * </p>
     *

     */
    public static void declare() {
        log.trace("打印banner成功！");
    }

}
