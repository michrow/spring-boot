package com.example.securitydemo.mapper;

import com.example.securitydemo.pojo.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRoleMapperTest {

    @Autowired(required = false)
    private UserRoleMapper userRoleMapper;
    @Test
    public void listByUserId() {
        List<UserRole> userRoles = userRoleMapper.listByUserId(1);
        for (UserRole userRole:userRoles
             ) {
            System.out.println(userRole.toString());
        }
    }
}