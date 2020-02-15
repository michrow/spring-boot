package com.example.demo.db.dao.db2;

import com.example.demo.db.pojo.Order;
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
public class AdvanceDaoTest {
    @Autowired(required = false)
    private AdvanceDao advanceDao;
    @Test
    public void queryOrderWithUserByOrderNumber() {
        String orderNumber = "201807010001";
        Order order = advanceDao.queryOrderWithUserByOrderNumber(orderNumber);
        log.info(order.toString());
    }

    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() {
        String orderNumber = "201807010001";
        Order order = advanceDao.queryOrderWithUserAndDetailByOrderNumber(orderNumber);
        log.info(order.toString());
    }

    @Test
    public void queryOrderWithUserAndDetailItemByOrderNumber() {
        String orderNumber = "201807010001";
        Order order = advanceDao.queryOrderWithUserAndDetailItemByOrderNumber(orderNumber);
        log.info(order.getUser().toString());
        log.info(order.getDetails().toString());
    }
}