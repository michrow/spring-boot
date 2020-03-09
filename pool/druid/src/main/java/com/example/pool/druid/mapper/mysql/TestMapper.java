package com.example.pool.druid.mapper.mysql;

import com.example.pool.druid.pojo.Test;
import com.example.pool.druid.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
    @Insert("insert into test (id,birth) values(#{id},#{birth})")
    int insert(Test test);

    @Select("select * from test where id=#{id}")
    Test select(int id);
}
