package com.example.pool.druid.controller;

import com.example.pool.druid.pojo.User;
import com.example.pool.druid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mysql")
public class MysqlController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.selectUserById(id);
    }

    @GetMapping("/users")
    public List<User> listUsers(){
        return userService.listUsers();
    }
}
