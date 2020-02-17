package com.example.demo.db.service;

import com.example.demo.db.dao.mysql.CountryMapper;
import com.example.demo.db.pojo.Country;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired(required = false)
    private CountryMapper countryMapper;

    public List<Country> getAllByPage(Country country){

        if (country.getPage() != null && country.getRows() != null) {
            PageHelper.startPage(country.getPage(), country.getRows());
        }
        List<Country> countries = countryMapper.queryAllCountry(country);
        return countries;
    }

    public void save(Country country) {
        if (country.getId() != null) {
            countryMapper.updateByPrimaryKey(country);
        } else {
            countryMapper.insert(country);
        }
    }

    public Country getById(Integer id) {
       return countryMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        countryMapper.deleteByPrimaryKey(id);
    }
}
