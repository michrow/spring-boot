package com.example.demo.controller;

import com.example.demo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
public class HelloController {

    @GetMapping(value = "/hello")
    public String sayHello(){
        Student student = new Student("xiaowang");
        return student.getName();
    }

}
