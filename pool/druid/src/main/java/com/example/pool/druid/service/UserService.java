package com.example.pool.druid.service;


import com.example.pool.druid.mapper.db2.UserDb2Mapper;
import com.example.pool.druid.mapper.mysql.UserMapper;
import com.example.pool.druid.pojo.User;
import com.example.pool.druid.pojo.UserDb2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private UserDb2Mapper userDb2Mapper;

    public User selectUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }


    public User selectUserByName(String name){
        return userMapper.selectByName(name);
    }

    public List<User> listUsers() {
        return userMapper.selectAll();
    }


    public UserDb2 selectUserDb2ById(Integer id) {
        return userDb2Mapper.selectByPrimaryKey(id);
    }
}
