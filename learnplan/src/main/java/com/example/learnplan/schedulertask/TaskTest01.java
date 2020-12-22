package com.example.learnplan.schedulertask;

import com.example.learnplan.config.SchedulerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wangfk
 */
@Component
public class TaskTest01 {
    
    @Resource
    private SchedulerConfig schedulerConfig;
    private int count=0;

    /**
     * 每6s执行一次
     * 添加定时任务注释     @Scheduled(cron="")
     * */
    private void process(){
        if(!Boolean.parseBoolean(schedulerConfig.getScheduled())){
            System.out.println("定时器已关闭！");
            return;
        }
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
