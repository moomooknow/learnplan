package com.example.learnplan.operation.equals;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * hashSet 去重原理
 *
 * @author wangfk
 */
@Data
@AllArgsConstructor
public class Student {
  private String name;
  private Integer age;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return name.equals(student.name) && age.equals(student.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}

class DeduplicationTest {
  public static void main(String[] args) {
    List<Student> list = new ArrayList<>();
    list.add(new Student("ym", 18));
    list.add(new Student("wlh", 17));
    list.add(new Student("ym", 18));
    list.add(new Student("wfk", 19));
    list.add(new Student("wlh", 17));
    // 1.HashSet去重 重写equals hashCode 方法 无序
    List<Student> newStudent1 = new ArrayList<>(new HashSet<>(list));
    newStudent1.forEach(System.out::println);
    // 2.java8 stream
    list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
    // 3.list.contains() 有序
    List<Student> newStudent2 = new ArrayList<>();
    for (Student student : list) {
      if (!newStudent2.contains(student)) {
        newStudent2.add(student);
      }
    }
    newStudent2.forEach(System.out::println);
  }
}
