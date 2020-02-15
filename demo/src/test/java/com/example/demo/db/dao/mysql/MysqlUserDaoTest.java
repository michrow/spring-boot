package com.example.demo.db.dao.mysql;

import com.example.demo.db.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MysqlUserDaoTest {

    @Autowired(required = false)
    private MysqlUserDao userDao;

    @Test
    public void queryUserById() {
    }

    @Test
    public void queryUserAll() {
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("wxh");
        user.setAge(25);
        user.setGender(1);
        user.setStatus(1);
        user.setRemark("露台");
        userDao.insertUser(user);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }
}