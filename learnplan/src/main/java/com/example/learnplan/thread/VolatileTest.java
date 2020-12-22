package com.example.learnplan.thread;

/** @author wangfk */
public class VolatileTest {
  public static void main(String[] args) {
    ThreadRun threadRun = new ThreadRun();
    threadRun.start();
    // main 线程等待 threadRun执行完毕
    // threadRun.join();
    for (; ; ) {
      synchronized (threadRun) {
        if (threadRun.isFlag()) {
          System.out.println("你变了");
        }
      }
    }
  }
}

class ThreadRun extends Thread {
  private volatile boolean flag = false;

  public boolean isFlag() {
    return flag;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    flag = true;
    System.out.println("flag = " + flag);
  }
}
