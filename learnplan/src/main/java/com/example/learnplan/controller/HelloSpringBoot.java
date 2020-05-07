package com.example.learnplan.controller;

import com.example.learnplan.config.LearnPlanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wfk
 */
@RestController
public class HelloSpringBoot {
    
    @Autowired
    private LearnPlanConfig learnPlanConfig;
    @Autowired
    private Environment environment;
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello spring boot" +
                " " + 
                environment.getProperty("com.application.name") + 
                learnPlanConfig.getName() + 
                learnPlanConfig.getDescribe() +
                "yes";
    }
}
