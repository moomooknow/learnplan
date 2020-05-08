package com.example.learnplan.controller;

import com.example.learnplan.model.User;
import com.example.learnplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getUser")
    public User getUser() {
        //save
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);        
        userRepository.save(new User("ym1", "ym@126.com", "ym", "ym123456",formattedDate));
        //查询
        User user=userRepository.findByUserName("ym");
        //删除
        userRepository.delete(user);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=userRepository.findAll();
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return users;
    }
}
