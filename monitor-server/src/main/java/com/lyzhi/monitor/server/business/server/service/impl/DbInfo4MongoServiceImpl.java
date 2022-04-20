package com.lyzhi.monitor.server.business.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lyzhi.monitor.server.business.server.service.IDbInfo4MongoService;
import com.google.common.collect.Lists;
import com.lyzhi.monitor.server.db.MongoUtils;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoIterable;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Mongo数据库信息服务实现类
 * </p>
 *
 */
@Service
public class DbInfo4MongoServiceImpl implements IDbInfo4MongoService {

    /**
     * <p>
     * 获取Mongo信息列表
     * </p>
     *
     * @param uri URI
     * @return Mongo信息列表
     *
     */
    @Override
    public List<JSONObject> getMongoInfoList(String uri) {
        List<JSONObject> jsonObjects = Lists.newArrayList();
        @Cleanup
        MongoClient client = MongoUtils.getClient(uri);
        if (client != null) {
            MongoIterable<String> databaseNames = client.listDatabaseNames();
            for (String databaseName : databaseNames) {
                DB database = client.getDB(databaseName);
                CommandResult serverStatus = database.getStats();
                JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(serverStatus, SerializerFeature.WriteMapNullValue), Feature.OrderedField);
                jsonObjects.add(jsonObject);
            }
            return jsonObjects;
        }
        return jsonObjects;
    }

}