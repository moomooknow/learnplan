package com.example.learnplan.repository;


import com.example.learnplan.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wfk
 */
public interface UserRepository extends JpaRepository<User,Long> {
    
    /**
     * 自定义属性查询test
     * @param userName 
     * @return 
     * */
    User findByUserName(String userName);
    
    /**
     * 自定义属性查询test
     * @param username
     * @param email
     * @return 
     * */
    User findByUserNameOrEmail(String username, String email);

    /**
     * 自定义属性查询test
     * @param username
     * @param password
     * @return
     * */
    User findByUserNameAndPassWord(String username,String password);
    
    /**
     * 自定义分页查询
     * @param userName
     * @param pageable
     * @return 
     * */
    Page<User> findByUserName(String userName, Pageable pageable);

    @Modifying
    @Query("update User u set u.userName = ?1 where u.id = ?2")
    int modifyByIdAndUserId(String  userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteByUserId(Long id);

    @Transactional(timeout = 10)
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
