package com.example.demo.db.dao.mysql;

import com.example.demo.db.pojo.Country;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryMapper {

    List<Country> queryAllCountry(Country country);

    int deleteByPrimaryKey(Integer id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}