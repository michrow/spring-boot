package com.example.taskdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync    //启用异步
@EnableScheduling   //启动定时任务
public class TaskdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskdemoApplication.class, args);
    }

}
