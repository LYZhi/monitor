package com.lyzhi.monitor.agent;

import com.lyzhi.monitor.common.web.tools.CustomizationBeanHandler;
import com.lyzhi.monitor.common.web.tools.UniqueBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(nameGenerator = UniqueBeanNameGenerator.class)
public class AgentApplication extends CustomizationBeanHandler {

    public static void main(String[] args) {
        SpringApplication.run(AgentApplication.class, args);
    }

}

