package com.lyzhi.monitor.client.springboot.starter.selector;

import com.lyzhi.monitor.client.springboot.starter.annotation.EnableMonitoring;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * <p>
 * 监控客户端自动配置类选择器
 * </p>
 *
 *
 */
public class EnableMonitoringPlugSelector implements DeferredImportSelector, BeanClassLoaderAware {

    /**
     * 类加载器
     */
    private ClassLoader beanClassLoader;

    /**
     * <p>
     * 选择性加载自动配置类
     * </p>
     *
     * @param metadata 注释元数据
     * @return 要导入的所有配置类全名
     *
     */
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        // 从spring.factories中获取的所有通过@EnableMonitoring注解引进来的自动配置类，并进行去重操作
        List<String> factories = new ArrayList<>(new LinkedHashSet<>(
                SpringFactoriesLoader.loadFactoryNames(EnableMonitoring.class, this.beanClassLoader)));
        if (factories.isEmpty()) {
            throw new IllegalStateException("没找到监控客户端自动配置类！");
        }
        return factories.toArray(new String[0]);
    }

    /**
     * <p>
     * 设置类加载器
     * </p>
     *
     * @param classLoader 类加载器
     *
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

}