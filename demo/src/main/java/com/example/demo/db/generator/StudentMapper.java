package com.example.demo.db.generator;

import com.example.demo.db.generator.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String name);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}