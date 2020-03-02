package com.example.securitydemo.service;

import com.example.securitydemo.mapper.UserMapper;
import com.example.securitydemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }


    public User selectUserByName(String name){
        return userMapper.selectByName(name);
    }

}
