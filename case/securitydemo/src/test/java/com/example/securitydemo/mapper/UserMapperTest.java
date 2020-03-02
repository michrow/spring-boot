package com.example.securitydemo.mapper;

import com.example.securitydemo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserMapperTest {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);

        log.info(user.toString());
    }
}