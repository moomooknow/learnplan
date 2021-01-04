package com.example.learnplan.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;

/** @author wangfk */
public class ThreadPoolTest {
  public static void main(String[] args) {
    ExecutorService executor = ThreadUtil.newExecutor(100, 120, Integer.MAX_VALUE);
    int num = 200;
    for (int i = 0; i < num; i++) {
      executor.execute(() -> System.out.println(Thread.currentThread().getName()));
    }
    executor.shutdown();
  }
}
