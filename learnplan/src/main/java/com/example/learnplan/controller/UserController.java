package com.example.learnplan.controller;

import com.example.learnplan.model.User;
import com.example.learnplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 */
@CacheConfig(cacheNames = "user")
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
        //select
        User user=userRepository.findByUserName("ym");
        //delete
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

    @RequestMapping("/getUserTestRedisValue")
    @Cacheable(value = "user-key")
    public User getUserTestRedisValue(){
        User user = new User("ym@126.com", "ym", "ym123456", "ym","123");
        System.out.println("调用了方法，没有从Redis中取");
        return user;
    }

    @RequestMapping("/getUserTestRedisKey")
    /**
     * 当 @Cacheable(key = "'list'")时，需在本类添加 @CacheConfig(cacheNames = "user")
     * */
    @Cacheable(key = "'list'")
    public User getUserTestRedisKey(){
        User user = new User("ym@126.com", "ym", "ym123456", "ym","123");
        System.out.println("调用了方法，没有从Redis中取");
        return user;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
