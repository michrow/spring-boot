package com.example.demo.db.pojo;

import com.ibm.db2.cmx.annotation.Column;
import com.ibm.db2.cmx.annotation.Id;
import lombok.Data;

import javax.annotation.Generated;
import java.beans.Transient;

@Data
public class BaseEntity {

    private Integer page = 1;
    private Integer rows = 10;
}
