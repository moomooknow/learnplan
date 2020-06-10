package com.example.learnplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangfk
 * 定时任务 @EnableScheduling  
 */
@SpringBootApplication
@EnableSwagger2
public class LearnPlanApplication {

    public static void main(String[] args) {
        System.out.println("The service to start.");
        SpringApplication.run(LearnPlanApplication.class, args);
        System.out.println("The service has started.");
    }

}
