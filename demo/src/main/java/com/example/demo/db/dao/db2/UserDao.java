package com.example.demo.db.dao.db2;

import com.example.demo.db.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 通过用户id查询用户
     * @param id
     * @return
     */
    public User queryUserById(@Param("id") int id);

    /**
     * 查询所用用户
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     * @param user
     */
    public int insertUser(User user);

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

    /**
     * 模糊按用户名查询用户
     * @param name
     * @return
     */
    public List<User> queryUserByName(@Param("name") String name);

    /**
     * 按照名字或者年龄查询
     * @param name
     * @param age
     * @return
     */
    public List<User> queryUserByNameOrAge(@Param("name") String name,@Param("age") int age);

    /**
     * 按照id查询
     * @param ids
     * @return
     */
    public List<User> queryUserByIds(@Param("ids") int [] ids);
}
