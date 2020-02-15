package com.example.demo.db.dao.mysql;

import com.example.demo.db.pojo.User;

import java.util.List;

public interface MysqlUserDao {

    /**
     * 通过用户id查询用户
     * @param id
     * @return
     */
    public User queryUserById(int id);

    /**
     * 查询所用用户
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据用户ID删除用户
     * @param id
     */
    public void deleteUser(int id);

}
