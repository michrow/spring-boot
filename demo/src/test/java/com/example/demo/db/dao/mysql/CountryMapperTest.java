package com.example.demo.db.dao.mysql;

import com.example.demo.db.pojo.Country;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CountryMapperTest {
    @Autowired(required = false)
    private CountryMapper countryMapper;
    @Test
    public void queryAllCountry() {

    }
}