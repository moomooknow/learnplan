package com.example.learnplan.java8;

/** @author wangfk */
@FunctionalInterface
public interface TestFunctionInterface {

  /** 函数式接口有且仅有一个抽象方法，可以有静态方法及默认方法 */
  static void staticMethod() {
    System.out.println("staticMethod");
  }

  /**
   * 自定义函数式接口
   *
   * @param a
   * @param b
   */
  void abstractMethod(int a, int b);
}
