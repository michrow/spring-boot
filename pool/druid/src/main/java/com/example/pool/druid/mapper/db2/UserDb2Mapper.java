package com.example.pool.druid.mapper.db2;


import com.example.pool.druid.pojo.UserDb2;

public interface UserDb2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDb2 record);

    int insertSelective(UserDb2 record);

    UserDb2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDb2 record);

    int updateByPrimaryKey(UserDb2 record);
}