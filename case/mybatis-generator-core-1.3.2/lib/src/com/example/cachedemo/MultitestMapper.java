package com.example.cachedemo;

import com.example.cachedemo.Multitest;

public interface MultitestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Multitest record);

    int insertSelective(Multitest record);

    Multitest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Multitest record);

    int updateByPrimaryKey(Multitest record);
}