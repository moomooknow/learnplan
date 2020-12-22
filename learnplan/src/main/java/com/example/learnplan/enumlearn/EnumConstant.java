package com.example.learnplan.enumlearn;

/** @author wangfk */
public class EnumConstant {
  enum EnumTest {
    /** 规范 */
    ZYS,
    /** 规范 */
    YM,
    /** 规范 */
    WLH
  }

  public static void main(String[] args) {
    EnumTest enumTest = EnumTest.WLH;
    switch (enumTest) {
      case YM:
        enumTest = EnumTest.WLH;
        break;
      case WLH:
      case ZYS:
        enumTest = EnumTest.YM;
        break;
      default:
    }
    System.out.println(enumTest);
  }
}
