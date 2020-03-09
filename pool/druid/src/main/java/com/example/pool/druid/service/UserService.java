package com.example.pool.druid.service;


import com.example.pool.druid.mapper.db2.UserDb2Mapper;
import com.example.pool.druid.mapper.mysql.TestMapper;
import com.example.pool.druid.mapper.mysql.UserMapper;
import com.example.pool.druid.pojo.Test;
import com.example.pool.druid.pojo.User;
import com.example.pool.druid.pojo.UserDb2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private DataSource db2DataSource;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private UserDb2Mapper userDb2Mapper;

    @Autowired(required = false)
    private TestMapper testMapper;

    public User selectUserById2(Integer id){
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

    public int insertTest(int id){
        Test test = new Test();
        test.setId(id);
        test.setBirth(new Date());
        return  testMapper.insert(test);
    }

    public Test selectTest(){
        return  testMapper.select(2);
    }

    /**
     * 测试事务
     * 第一条插入成功，第二条报错则第一天也回滚
     */
    @Transactional(value = "mysqlTransactionManager")
    public void testTransaction(){
        insertTest(2);
        insertTest(5);
    }
}
