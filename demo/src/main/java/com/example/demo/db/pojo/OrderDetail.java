package com.example.demo.db.pojo;

import lombok.Data;

@Data
public class OrderDetail {
    private int id;
    private int orderId;
    private int itemId;
    private double totalPrice;
    private int status;
}
