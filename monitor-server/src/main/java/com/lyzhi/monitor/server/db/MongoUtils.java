package com.lyzhi.monitor.server.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * mongo工具类
 * </p>
 *
 */
@Slf4j
public class MongoUtils {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *
     */
    private MongoUtils() {
    }

    /**
     * <p>
     * 获取 MongoClient
     * </p>
     *
     * @param uri URI
     * @return {@link MongoClient}
     *
     */
    public static MongoClient getClient(String uri) {
        try {
            return new MongoClient(new MongoClientURI(uri));
        } catch (Exception e) {
            log.error("与mongo数据库建立连接异常！");
            return null;
        }
    }

    /**
     * <p>
     * Mongo数据库是否可连接
     * </p>
     *
     * @param mongoClient {@link MongoClient}
     * @return boolean 是 或者 否
     *
     */
    public static boolean isConnect(MongoClient mongoClient) {
        if (mongoClient == null) {
            return false;
        }
        try {
            MongoIterable<String> databaseNames = mongoClient.listDatabaseNames();
            MongoCursor<String> it = databaseNames.iterator();
            if (it.hasNext()) {
                it.next();
            }
            // 关闭
            it.close();
            return true;
        } catch (Exception e) {
            log.error("检查连接异常！", e);
            return false;
        }
    }

    /**
     * <p>
     * 关闭 MongoClient
     * </p>
     *
     * @param mongoClient {@link MongoClient}
     *
     */
    public static void close(MongoClient mongoClient) {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

}
