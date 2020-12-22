package com.example.learnplan.schedulertask;

import com.example.learnplan.config.SchedulerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
@Component
public class TaskTest02 {
    
    @Resource
    private SchedulerConfig schedulerConfig;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     *initialDelay 第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执行一次
     * 添加定时任务注释    @Scheduled(initialDelay=1000,fixedRate = 6000)
     */
    public void reportCurrentTime() {
        if(!Boolean.parseBoolean(schedulerConfig.getScheduled())){
            System.out.println("定时器已关闭！");
            return;
        }

        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
