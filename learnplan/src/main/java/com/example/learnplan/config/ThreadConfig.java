package com.example.learnplan.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** @author wangfk */
@Component
@Data
public class ThreadConfig {
  @Value("${com.thread.corePoolSize}")
  private String corePoolSize;
}
