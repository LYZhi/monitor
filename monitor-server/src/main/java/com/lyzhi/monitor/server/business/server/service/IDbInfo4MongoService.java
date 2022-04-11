package com.lyzhi.monitor.server.business.server.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * <p>
 * Mongo数据库信息服务类
 * </p>
 *
 */
public interface IDbInfo4MongoService {

    /**
     * <p>
     * 获取Mongo信息列表
     * </p>
     *
     * @param uri URI
     * @return Mongo信息列表
     *
     */
    List<JSONObject> getMongoInfoList(String uri);
}
