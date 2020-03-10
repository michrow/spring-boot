package com.example.multiswitch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Multitest {
    private Integer id;

    private String dbType;

    private String remark;

    private Date birth;

}