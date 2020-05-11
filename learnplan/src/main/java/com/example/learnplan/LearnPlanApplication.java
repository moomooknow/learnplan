package com.example.learnplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wfk
 * 定时任务 @EnableScheduling  
 */
@SpringBootApplication
public class LearnPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnPlanApplication.class, args);
    }

}
