package com.lyzhi.monitor.agent;

import com.lyzhi.monitor.common.web.toolkit.CustomizationBeanHandler;
import com.lyzhi.monitor.common.web.toolkit.UniqueBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

/**
 * <p>
 * 本SpringApplication类提供了一个方便的方式来引导该从Spring应用程序的main()方法开始。<br>
 * 在许多情况下，您可以委托给静态SpringApplication.run方法
 * </p>
 *
 */
@EnableRetry
@SpringBootApplication
@ComponentScan(nameGenerator = UniqueBeanNameGenerator.class)
public class AgentApplication extends CustomizationBeanHandler {

    public static void main(String[] args) {
        SpringApplication.run(AgentApplication.class, args);
    }

}
