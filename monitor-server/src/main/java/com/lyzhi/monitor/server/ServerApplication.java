package com.lyzhi.monitor.server;

import com.lyzhi.monitor.client.springboot.starter.annotation.EnableMonitoring;
import com.lyzhi.monitor.common.web.toolkit.CustomizationBeanHandler;
import com.lyzhi.monitor.common.web.toolkit.UniqueBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * 本SpringApplication类提供了一个方便的方式来引导该从Spring应用程序的main()方法开始。<br>
 * 在许多情况下，您可以委托给静态SpringApplication.run方法。
 * </p>
 *
 */
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan(nameGenerator = UniqueBeanNameGenerator.class)
@EnableTransactionManagement
@EnableMonitoring
@EnableRetry
public class ServerApplication extends CustomizationBeanHandler {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
