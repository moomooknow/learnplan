package com.example.learnplan;

import com.example.learnplan.controller.HelloSpringBoot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnPlanApplicationTests {
    
    @Autowired
    private HelloSpringBoot helloSpringBoot;

    @Test
    public void getHello(){
        final String greeting = helloSpringBoot.hello();
        Assert.assertEquals("hello spring boot",greeting);
    }
}
