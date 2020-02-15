package com.example.demo.db.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private int id;
    private int userId;
    private String orderNumber;
    private Date create;
    private Date updated;
    //用户信息
    private User user;
    //订单详情
    private List<OrderDetail> details;
}
