package com.example.learnplan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** @author wangfk */
@Component
@Order(1)
public class OrderRunner1 implements CommandLineRunner {
  @Override
  public void run(String... args) {
    System.out.println("The OrderRunner1 start to initialize ...");
  }
}
