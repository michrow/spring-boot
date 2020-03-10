package com.example.toolsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 16:35 2020/3/10
 * @Modified By:
 */
@Controller
@RequestMapping("/user")
public class XssController {

    @PostMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse response,
                        Map<String,Object> msg){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String s = username+"登录成功";
        msg.put("msg",s);
        return "main";
    }
}
