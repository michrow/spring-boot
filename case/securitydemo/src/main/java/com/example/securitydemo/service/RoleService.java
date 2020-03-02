package com.example.securitydemo.service;

import com.example.securitydemo.mapper.RoleMapper;
import com.example.securitydemo.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;

    public Role selectRoleById(Integer id){
        return roleMapper.selectByPrimaryKey(id);
    }
}
