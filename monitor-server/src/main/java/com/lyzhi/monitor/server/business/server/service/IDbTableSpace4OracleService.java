package com.lyzhi.monitor.server.business.server.service;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 * Oracle数据库表空间服务接口
 * </p>
 *
 */
public interface IDbTableSpace4OracleService {

    /**
     * <p>
     * 获取表空间列表(按文件)
     * </p>
     *
     * @param url      url
     * @param username 用户名
     * @param password 密码
     * @return 表空间列表(按文件)
     * @throws SQLException SQL异常
     *
     */
    List<Entity> getTableSpaceListFile(String url, String username, String password) throws SQLException;

    /**
     * <p>
     * 获取表空间列表
     * </p>
     *
     * @param url      url
     * @param username 用户名
     * @param password 密码
     * @return 表空间列表
     * @throws SQLException SQL异常
     *
     */
    List<Entity> getTableSpaceListAll(String url, String username, String password) throws SQLException;

}
