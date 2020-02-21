package com.example.demo.web.controller;

import com.example.demo.web.config.UserNotExistException;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if("hello".equals(user)){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    @RequestMapping("/success")
    public String sucess(Map<String,Object> map){
        map.put("hello","王肖辉");
        map.put("names", Arrays.asList("xiaoli","xiaowang","xiaozhang"));
        return "success";
    }
}
