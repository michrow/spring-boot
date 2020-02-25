package com.example.cachedemo.controller;

import com.example.cachedemo.pojo.City;
import com.example.cachedemo.pojo.Country;
import com.example.cachedemo.service.CityService;
import com.example.cachedemo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;


    @GetMapping("/country/{id}")
    public Country getCountry(@PathVariable("id") Integer id){
        return countryService.getCountry(id);
    }

    @GetMapping("/country/code/{countrycode}")
    public Country getCountryByCode(@PathVariable("countrycode") String countrycode){
        return countryService.getCountryByCode(countrycode);
    }


    @PutMapping("/country")
    public Country addCountry(Country country){
        Country count = countryService.updateCountry(country);
        return count;
    }

    @DeleteMapping("/country/{id}")
    public String delCountry(@PathVariable("id") Integer id){
        countryService.deleteCountry(id);
        return "删除成功";
    }

    @GetMapping("/city/{id}")
    public City getCity(@PathVariable("id") Long id){
        return cityService.getCity(id);
    }

}
