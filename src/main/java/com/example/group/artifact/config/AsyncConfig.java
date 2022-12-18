package com.example.group.artifact.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name="taskExecutor")
    public Executor threadConfig() {
        ThreadPoolTaskExecutor threadSetting = new ThreadPoolTaskExecutor();
        threadSetting.setCorePoolSize(2);
        threadSetting.setMaxPoolSize(2);
        threadSetting.setQueueCapacity(100);
        threadSetting.initialize();
        return threadSetting;
    }
}
