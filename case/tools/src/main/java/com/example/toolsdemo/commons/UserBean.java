package com.example.toolsdemo.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 13:45 2020/3/10
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    private String userId;
    private String userName;
    private Long number;
    private Date birth;
    private String[] chird;

    public UserBean(String userId,String userName){
        this.userId = userId;
        this.userName = userName;
    }

}
