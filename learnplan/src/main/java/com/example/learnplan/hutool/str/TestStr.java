package com.example.learnplan.hutool.str;

import java.io.File;

/** @author wangfk */
public class TestStr {
  public static void main(String[] args) {
    String sysPath = new File(TestStr.class.getResource("").getPath()).getPath() + "/temp/";
    System.out.println(sysPath);
  }
}
