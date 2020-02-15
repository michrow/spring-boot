package com.example.demo.db.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private String name;
    private int gender;
    private int age;
    private int status;
    private String remark;
    private String myAddr;
}
