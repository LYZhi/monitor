package com.lyzhi.monitor.server.business.server.service.impl;

import com.lyzhi.monitor.common.exception.DbException;
import com.lyzhi.monitor.server.business.server.service.IDbInfo4RedisService;
import com.lyzhi.monitor.server.db.RedisUtils;
import lombok.Cleanup;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * <p>
 * Redis数据库信息服务类
 * </p>
 *
 */
@Service
public class DbInfo4RedisServiceImpl implements IDbInfo4RedisService {

    /**
     * <p>
     * 获取Redis信息
     * </p>
     *
     * @param host     主机
     * @param port     端口
     * @param password 密码
     * @return Redis信息
     * @throws DbException 自定义数据库异常
     *
     */
    @Override
    public String getRedisInfo(String host, int port, String password) throws DbException {
        // 获取 Jedis
        @Cleanup
        Jedis jedis = RedisUtils.getJedis(host, port, password);
        if (jedis != null) {
            return jedis.info();
        } else {
            throw new DbException("获取Redis信息异常！");
        }
    }

}
