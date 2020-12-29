package com.example.learnplan.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;

/** @author wangfk */
public class ThreadPoolTest {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(args));
    System.out.println(args[0]);
    ExecutorService executor = ThreadUtil.newExecutor(80);
    for (int i = 0; i < 100; i++) {
      executor.execute(() -> System.out.println(Thread.currentThread().getName()));
    }
    executor.shutdown();
  }
}
