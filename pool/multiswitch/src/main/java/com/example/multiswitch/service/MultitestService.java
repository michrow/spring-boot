package com.example.multiswitch.service;

import com.example.multiswitch.dbaop.DataSource;
import com.example.multiswitch.dbaop.DataSourceNames;
import com.example.multiswitch.mapper.MultitestMapper;
import com.example.multiswitch.pojo.Multitest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MultitestService {

    @Autowired(required = false)
    private MultitestMapper multitestMapper;

    public List<Multitest> listMultitest1(){
        return multitestMapper.listMultitest();
    }

    public int addMultiTest1(){
        Multitest record = new Multitest(2,"test","test",new Date());
        return multitestMapper.insert(record);
    }

    @DataSource(value = DataSourceNames.TWO)
    public List<Multitest> listMultitest2(){
        return multitestMapper.listMultitest();
    }

    @DataSource(value = DataSourceNames.TWO)
    public int addMultiTest2(){
        Multitest record = new Multitest(2,"test","test",new Date());
        return multitestMapper.insert(record);
    }


}
