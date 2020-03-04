package com.example.pool.druid.controller;

import com.example.pool.druid.pojo.UserDb2;
import com.example.pool.druid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db2")
public class Db2Controller {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public UserDb2 getUserDb2ById(@PathVariable("id") Integer id){
        return userService.selectUserDb2ById(id);
    }
}
