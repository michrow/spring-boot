package com.example.taskdemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTaskService {

    @Scheduled(cron = "0/10 * * * * ?")
    public void hello(){
        System.out.println("hello ....");
    }
}
