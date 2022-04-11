package com.lyzhi.monitor.server.business.server.service;

import com.lyzhi.monitor.common.exception.DbException;

/**
 * <p>
 * Redis数据库信息服务接口
 * </p>
 *
 */
public interface IDbInfo4RedisService {

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
    String getRedisInfo(String host, int port, String password) throws DbException;
}
