package com.developmentteam.brothersdeliveryapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig  {

   @Bean(name = "default")
   public Executor getDefaultAsyncExecutor() {
      ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
      int availableProcessors = Runtime.getRuntime().availableProcessors();
      threadPoolTaskExecutor.setCorePoolSize(availableProcessors);
      threadPoolTaskExecutor.setMaxPoolSize(availableProcessors * 2);
      threadPoolTaskExecutor.setQueueCapacity(100);
      threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
      threadPoolTaskExecutor.setThreadNamePrefix("bth-async");
      threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
      threadPoolTaskExecutor.initialize();
      return threadPoolTaskExecutor;
   }

   @Bean(name = "custom")
   public Executor getCustomAsyncExecutor() {
      ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
      threadPoolTaskExecutor.setCorePoolSize(2);
      threadPoolTaskExecutor.setMaxPoolSize(5);
      threadPoolTaskExecutor.setQueueCapacity(100);
      threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
      threadPoolTaskExecutor.setThreadNamePrefix("bth-async");
      threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
      threadPoolTaskExecutor.initialize();
      return threadPoolTaskExecutor;
   }
}
