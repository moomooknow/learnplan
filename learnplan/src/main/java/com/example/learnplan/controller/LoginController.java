package com.example.learnplan.controller;

import com.example.learnplan.model.User;
import com.example.learnplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangfk
 */
@RestController
public class LoginController {
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("login/index");
    }
    
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam String name , @RequestParam String password, HttpServletRequest httpServletRequest, Model model){
        ModelAndView mv1 = new ModelAndView("login/index");
        ModelAndView mv2 = new ModelAndView("login/login");
        User user = userRepository.findByUserNameAndPassWord(name,password);
        if(user != null) {
            return mv2;
        }else {
            return mv1;
        }
    }
}
