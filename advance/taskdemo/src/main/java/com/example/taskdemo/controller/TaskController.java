package com.example.taskdemo.controller;

import com.example.taskdemo.service.AsynTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    AsynTaskService asynTask;

    @GetMapping("/hello")
    public String hello(){
        asynTask.hello();
        return "hello";
    }
}
