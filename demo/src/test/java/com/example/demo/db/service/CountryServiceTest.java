package com.example.demo.db.service;

import com.example.demo.db.pojo.Country;
import com.github.pagehelper.PageInfo;
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
public class CountryServiceTest {
    @Autowired
    private CountryService countryService;
    @Test
    public void getAllByPage() {
        Country country = new Country();
        country.setCountrycode("BM");
        List<Country> countries = countryService.getAllByPage(country);
        PageInfo pageInfo = new PageInfo<Country>(countries);
        log.info("page"+pageInfo.getList().toString());
    }
}