package com.example.demo.db.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private int id;
    private int userId;
    private String orderNumber;
    private Date create;
    private Date update;
    private User user;
}
