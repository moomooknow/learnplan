package com.example.learnplan.controller;

import com.example.learnplan.config.LearnPlanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
                " " +
                learnPlanConfig.getDescribe();
    }
    
    @RequestMapping("/result")
    public Map<String,Object> getResult(){
        Map<String,Object> result = new HashMap<>(16);
        result.put("name","ym");
        result.put("describe",learnPlanConfig.getDescribe());
        return result;
    }
}
