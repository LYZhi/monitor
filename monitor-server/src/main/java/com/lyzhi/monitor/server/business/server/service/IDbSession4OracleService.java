package com.lyzhi.monitor.server.business.server.service;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * Oracle数据库会话服务接口
 * </p>
 *
 */
public interface IDbSession4OracleService {

    /**
     * <p>
     * 获取会话列表
     * </p>
     *
     * @param url      url
     * @param username 用户名
     * @param password 密码
     * @return 会话列表
     * @throws SQLException SQL异常
     *
     */
    List<Entity> getSessionList(String url, String username, String password) throws SQLException;

    /**
     * <p>
     * 结束会话
     * </p>
     *
     * @param url      url
     * @param username 用户名
     * @param password 密码
     * @param sids     sids
     * @param serials  serials
     * @throws SQLException SQL异常
     *
     */
    void destroySession(String url, String username, String password, List<Long> sids, List<Long> serials) throws SQLException;

}
