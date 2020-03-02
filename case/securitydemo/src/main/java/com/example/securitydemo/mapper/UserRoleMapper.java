package com.example.securitydemo.mapper;


import com.example.securitydemo.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRole key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> listByUserId(@Param("userId") Integer id);
}