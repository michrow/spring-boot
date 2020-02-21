package com.example.demo.web.controller;

import com.example.demo.web.config.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user not exitst");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        map.put("code","user not exitst");
        map.put("message",e.getMessage());
        /**
         * 通过javax.servlet.error.status_code 设置有效错误码
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
