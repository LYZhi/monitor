package com.lyzhi.monitor.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>
 * 集合工具类
 * </p>
 *
 */
public class CollectionUtils {

    /**
     * <p>
     * 私有化构造方法
     * </p>
     *

     */
    private CollectionUtils() {
    }

    /**
     * <p>
     * 根据条件进行去重
     * </p>
     *
     * @param <T>          泛型
     * @param keyExtractor 去重条件
     * @return {@link Predicate}

     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>(16);
        return object -> seen.putIfAbsent(keyExtractor.apply(object), Boolean.TRUE) == null;
    }

}
