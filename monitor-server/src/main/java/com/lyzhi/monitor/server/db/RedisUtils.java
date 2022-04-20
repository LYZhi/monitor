package com.lyzhi.monitor.server.db;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * <p>
 * Redis工具类
 * </p>
 *
 */
@Slf4j
public class RedisUtils {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     *
     */
    private RedisUtils() {
    }

    /**
     * <p>
     * 获取 Jedis
     * </p>
     *
     * @param host     主机
     * @param port     端口
     * @param password 密码
     * @return {@link Jedis}
     *
     */
    public static Jedis getJedis(String host, int port, String password) {
        try {
            Jedis jedis = new Jedis(host, port, 5000);
            if (StringUtils.isNotBlank(password)) {
                // 解密
                password = new String(Base64.getDecoder().decode(password), StandardCharsets.UTF_8);
                jedis.auth(password);
            }
            return jedis;
        } catch (Exception e) {
            log.error("与Redis数据库建立连接异常！");
            return null;
        }
    }

    /**
     * <p>
     * Redis数据库是否可连接
     * </p>
     *
     * @param jedis {@link Jedis}
     * @return 是 或者 否
     *
     */
    public static boolean isConnect(Jedis jedis) {
        if (jedis == null) {
            return false;
        }
        try {
            String ping = jedis.ping();
            return "PONG".equalsIgnoreCase(ping);
        } catch (Exception e) {
            log.error("检查连接异常！", e);
            return false;
        }
    }

    /**
     * <p>
     * 关闭 Jedis
     * </p>
     *
     * @param jedis {@link Jedis}
     *
     */
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}
