package com.example.learnplan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author wangfk
 * learn 项目启动时初始化资源 CommandLineRunner
 * 指定初始化顺序使用 @Order()注释
 */
@Component
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner start to initialize ...");
    }
}
