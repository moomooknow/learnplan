package com.example.learnplan.thread.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 线程工具类
 *
 * @author wangfk
 */
public class ThreadUtil {
  /** To nominate the thread name by self. */
  private static final ThreadFactory NAMED_THREAD_FACTORY =
      new ThreadFactoryBuilder().setNameFormat("rd-hbg-merchant-pool-%d").build();

  /**
   * To realize the ThreadPool, aim to avoid the OOM and trace the error by thread name. Rejected
   * policy:AbortPolicy -> Always throws RejectedExecutionException
   */
  public static ExecutorService executor =
      new ThreadPoolExecutor(
          20,
          20,
          0L,
          TimeUnit.MILLISECONDS,
          new LinkedBlockingQueue<>(1024),
          NAMED_THREAD_FACTORY,
          new ThreadPoolExecutor.AbortPolicy());
}
