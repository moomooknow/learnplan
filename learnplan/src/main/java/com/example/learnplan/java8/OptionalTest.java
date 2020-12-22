package com.example.learnplan.java8;

import com.example.learnplan.model.User;

import java.util.Optional;

/**
 * java8新特性optional
 *
 * @author wangfk
 */
public class OptionalTest {

  public static void main(String[] args) {

    OptionalTest optionalTest = new OptionalTest();
    optionalTest.optional();
  }

  public void optional() {
    User user = new User("ym");

    Optional<String> optional_empty = Optional.empty();
    // isPresent() 返回 Boolean
    System.out.println(optional_empty.isPresent());
    // get() 返回一个option的实例值
    Optional<String> optional_of = Optional.of("optional_of");
    System.out.println(optional_of.get());

    Optional<String> optional_ofNullable_null = Optional.ofNullable(null);
    System.out.println(optional_ofNullable_null.isPresent());

    Optional<String> optional_ofNullable_string = Optional.ofNullable("optional_ofNullable_string");
    System.out.println(optional_ofNullable_string.get());

    // ifPresent(Consumer<? super T> consumer) 判读是否为null并返回函数
    Optional.ofNullable(user).ifPresent(p -> System.out.println("姓名： " + p.getUserName()));

    // map()方法将对应funcation函数式接口中的对象，进行二次运算，封装成新的对象然后返回在Optional中
    System.out.println(Optional.ofNullable(user).map(User::getUserName).orElse("username 为 null"));
  }
}
