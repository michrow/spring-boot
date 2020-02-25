package com.example.cachedemo.mapper;

import com.example.cachedemo.pojo.Country;
import com.example.cachedemo.pojo.Country;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Integer id);

    Country selectByPrimaryCode(String countrycode);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}