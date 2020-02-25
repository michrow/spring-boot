package com.example.cachedemo.service;

import com.example.cachedemo.mapper.CityMapper;
import com.example.cachedemo.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"city"})
public class CityService {

    @Autowired(required = false)
    private CityMapper cityMapper;

    @Cacheable
    public City getCity(Long id){
        return cityMapper.selectByPrimaryKey(id);
    }
}
