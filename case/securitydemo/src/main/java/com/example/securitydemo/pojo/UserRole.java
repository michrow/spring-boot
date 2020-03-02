package com.example.securitydemo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {

    private Integer userId;

    private Integer roleId;

}