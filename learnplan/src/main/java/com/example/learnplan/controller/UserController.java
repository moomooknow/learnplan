package com.example.learnplan.controller;

import com.example.learnplan.model.User;
import com.example.learnplan.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "获取用户", notes = "无参数")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser() {
        //save
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);        
        userRepository.save(new User("ym", "ym@126.com", "ym", "ym123456",formattedDate));
        //select
        User user=userRepository.findByUserName("ym");
        //delete
        userRepository.delete(user);
        return user;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users=userRepository.findAll();
        return users;
    }

    /**
     * 使用value上的信息，来替换类上cacheNames的信息
     * 未指定 key  Spring使用默认策略生成key（RedisConfig类 重写keyGenerator()方法）
    * */
    @RequestMapping("/getUserTestRedisValue")
    @Cacheable(value = "user-value" , unless = "#result == null")
    public User getUserTestRedisValue(){
        User user = userRepository.findByUserName("ym");
        System.out.println("调用了方法，没有从Redis中取");
        return user;
    }

    /**
     * 指定key属性，Spring 使用自定义策略生成key  user::user-key
     * Redis 不支持存入null unless = "#result == null" 存入前判断
     * */
    @RequestMapping("/getUserTestRedisKey")
    @Cacheable(value = "user", key = "'user-key'", unless = "#result == null")
    public User getUserTestRedisKey(){
        User user = userRepository.findByUserName("ym");
        System.out.println("调用了方法，没有从Redis中取");
        return user;
    }
    
    @RequestMapping("/getPage")
    @Cacheable(value = "user" , unless = "#result == null")
    public List<User> getPageList(){
        //JPA 中，page是从0开始，不是从1开始；
        int page = 0;
        int size = 10;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page pages = userRepository.findAll(pageable);
        System.out.println("调用了方法，没有从Redis中取");
        return pages.getContent();
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
