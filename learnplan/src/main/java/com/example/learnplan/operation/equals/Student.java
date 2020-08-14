package com.example.learnplan.operation.equals;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;

/**
 * hashSet 去重原理
 * @author wangfk
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Integer age;
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
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
class HashSetTest{
    public static void main(String[] args) {
        HashSet<Student> hashSet = new HashSet<>(16);
        hashSet.add(new Student("ym", 18));
        hashSet.add(new Student("ym", 18));
        hashSet.forEach(System.out::println);
    }
}
