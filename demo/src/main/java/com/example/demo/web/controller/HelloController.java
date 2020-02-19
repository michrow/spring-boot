package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/success")
    public String sucess(Map<String,Object> map){
        map.put("hello","王肖辉");
        map.put("names", Arrays.asList("xiaoli","xiaowang","xiaozhang"));
        return "success";
    }
}
