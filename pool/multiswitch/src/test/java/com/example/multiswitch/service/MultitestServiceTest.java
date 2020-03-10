package com.example.multiswitch.service;

import com.example.multiswitch.pojo.Multitest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MultitestServiceTest {
    @Autowired
    private MultitestService multitestService;

    @Test
    public void listMultitest1() {
        List<Multitest> multitests = multitestService.listMultitest1();
        multitests.stream().forEach(multitest -> System.out.println(multitest.toString()));
    }

    @Test
    public void listMultitest2() {
        List<Multitest> multitests = multitestService.listMultitest2();
        multitests.stream().forEach(multitest -> System.out.println(multitest.toString()));
    }


    @Test
    @Transactional
    public void addMultiTest1() {
        multitestService.addMultiTest1();
        int i = 1/0;
    }

    @Test
    @Transactional
    public void addMultiTest2() {
        multitestService.addMultiTest2();
        int i = 1/0;
    }

    /**
     * 测试多数据源切换事物是否有问题，经测试正常，不知网上那些事物不生效什么情况？？
     */
    @Test
    @Transactional
    public void addMultiTest3(){
        multitestService.addMultiTest1();
        multitestService.addMultiTest2();
        int i=1/0;
    }
}