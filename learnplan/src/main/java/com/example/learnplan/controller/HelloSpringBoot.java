package com.example.learnplan.controller;

import com.example.learnplan.config.LearnPlanConfig;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/** @author wangfk */
@RestController
public class HelloSpringBoot {

  @Resource private LearnPlanConfig learnPlanConfig;
  @Resource private Environment environment;

  @RequestMapping("/hello")
  public String hello() {
    return "hello spring boot";
  }

  @RequestMapping("/result")
  public Map<String, Object> getResult() {
    Map<String, Object> result = new HashMap<>(16);
    result.put("name", environment.getProperty("com.application.name"));
    result.put("describe", learnPlanConfig.getDescribe());
    return result;
  }
}
