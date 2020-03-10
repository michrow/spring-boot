package com.example.multiswitch.service;

import com.example.multiswitch.mapper.MultitestMapper;
import com.example.multiswitch.pojo.Multitest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultitestService {
    @Autowired(required = false)
    private MultitestMapper multitestMapper;

    public List<Multitest> listMultitest(){
        return multitestMapper.listMultitest();
    }

}
