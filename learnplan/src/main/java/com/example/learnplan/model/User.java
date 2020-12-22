package com.example.learnplan.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/** @author wangfk */
@Entity
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id @GeneratedValue private Long id;

  @Column(nullable = false, unique = true)
  private String userName;

  @Column(nullable = false)
  private String passWord;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(unique = true)
  private String nickName;

  @Column(nullable = false)
  private String regTime;

  @Column(nullable = false)
  private int age;

  public User() {
    super();
  }

  public User(String name) {
    super();
    this.userName = name;
  }

  public User(String name, int age) {
    super();
    this.userName = name;
    this.age = age;
  }

  public User(String nickName, String email, String userName, String passWord, String regTime) {
    super();
    this.email = email;
    this.nickName = nickName;
    this.passWord = passWord;
    this.userName = userName;
    this.regTime = regTime;
  }

  @Override
  public String toString() {
    return "userName= " + userName + ", age= " + age;
  }
}
