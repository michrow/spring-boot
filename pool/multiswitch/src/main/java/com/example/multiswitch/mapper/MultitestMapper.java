package com.example.multiswitch.mapper;


import com.example.multiswitch.pojo.Multitest;

import java.util.List;

public interface MultitestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Multitest record);

    int insertSelective(Multitest record);

    Multitest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Multitest record);

    int updateByPrimaryKey(Multitest record);

    List<Multitest> listMultitest();
}