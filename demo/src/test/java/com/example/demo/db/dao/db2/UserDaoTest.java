package com.example.demo.db.dao.db2;

import com.example.demo.db.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired(required = false)
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
//    @Transactional(rollbackFor = Throwable.class)
    public void queryUserById() {
        User user = userDao.queryUserById(44);
        User user1 = userDao.queryUserById(44);
        log.info(user.toString());
    }

    @Test
    public void queryUserAll() {
        List<User> users = userDao.queryUserAll();
        for (User user:users
             ) {
            log.info(user.toString());
        }
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("wxh");
        user.setAge(25);
        user.setGender(1);
        user.setStatus(1);
        user.setRemark("露台");
        int id = userDao.insertUser(user);
        log.info("插入用户wxh对应ID："+id+":"+user.getId());
    }

    @Test
    public void updateUser() {
        User user = userDao.queryUserById(21);
        user.setName("王辉");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void queryUserByName() {
        List<User> users = userDao.queryUserByName("x");
        for (User user:users
                ) {
            log.info(user.toString());
        }
    }

    @Test
    public void queryUserByNameOrAge() {
        List<User> users = userDao.queryUserByNameOrAge("", 25);
        for (User user:users
                ) {
            log.info(user.toString());
        }
    }

    @Test
    public void queryUserByIds() {
        List<User> users = userDao.queryUserByIds(new int[]{1, 21, 41});
        for (User user:users
                ) {
            log.info(user.toString());
        }
    }
}