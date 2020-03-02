package com.example.securitydemo.service;

import com.example.securitydemo.mapper.UserRoleMapper;
import com.example.securitydemo.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired(required = false)
    private UserRoleMapper userRoleMapper;

    public List<UserRole> selectByUserId(Integer id){
        return userRoleMapper.listByUserId(id);
    }
}
