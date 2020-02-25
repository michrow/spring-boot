package com.example.cachedemo.redis;

import com.example.cachedemo.mapper.CountryMapper;
import com.example.cachedemo.pojo.Country;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestRedis {
    @Autowired(required = false)
    private CountryMapper countryMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01(){
//        stringRedisTemplate.opsForValue().append("msg","wxh");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        log.info(msg);
    }

    @Test
    public void test02(){
        Country country = countryMapper.selectByPrimaryKey(3);
        redisTemplate.opsForValue().set("count-03-json",country);
    }


}
