package com.lyzhi.monitor.common.web.tools;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.util.StringUtils;

/**
 * 唯一的bean名字生成器
 * 覆盖spring提供的默认beanName生成策略，使用全限定类名做唯一的bean名字
 */
public class UniqueBeanNameGenerator extends AnnotationBeanNameGenerator {

    /**
     * 生成Bean名字
     *
     * @param definition Bean定义
     * @param registry   Bean定义注册处，该类的作用主要是向注册表中注册BeanDefinition实例
     * @return Bean名字
     */
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        // 全限定类名
        String beanName = definition.getBeanClassName();
        if (StringUtils.hasText(beanName)) {
            return beanName;
        }
        return super.buildDefaultBeanName(definition, registry);
    }

}
