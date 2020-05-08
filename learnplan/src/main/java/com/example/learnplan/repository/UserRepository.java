package com.example.learnplan.repository;


import com.example.learnplan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wfk
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 自定义属性查询test
     * 
     * @param userName 
     * @return 
     * */
    User findByUserName(String userName);
    /**
     * 自定义属性查询test
     * 
     * @param username
     * @param email
     * @return 
     * 
     * */
    User findByUserNameOrEmail(String username, String email);
}
