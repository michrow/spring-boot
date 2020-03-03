package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.PushBuilder;

@Controller
@RequestMapping("/service")
public class ServicePushController {

    @GetMapping("/serviceWithPush")
    public  String serviceWithPush(HttpServletRequest request, PushBuilder pushBuilder){
        if(null!=pushBuilder){
            pushBuilder.path("/my/static/assets/ico/favicon.png").push();
        }
        return "hello";
    }

    @GetMapping("/serviceWithoutPush")
    public  String serviceWithPush(){
        return "hello";
    }

}
