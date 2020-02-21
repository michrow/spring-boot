package com.example.demo.web.controller;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //获取默认属性
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        //添加自定义
        map.put("my","my");

        //从请求中获取

        Map<String,Object> reqMap = (Map<String, Object>) webRequest.getAttribute("ext",0);
        map.putAll(reqMap);
        return map;
    }
}
