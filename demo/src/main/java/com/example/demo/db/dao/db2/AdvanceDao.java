package com.example.demo.db.dao.db2;

import com.example.demo.db.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvanceDao {
    /**
     * 根据订单号查询订单及用户信息
     * @param number
     * @return
     */
    public Order queryOrderWithUserByOrderNumber(@Param("number") String number);

    /**
     * 根据订单号查询用户及订单详情
     * @param number
     * @return
     */
    public Order  queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);

    /**
     * 根据订单号查询用户、订单详情、商品信息
     * @param number
     * @return
     */
    public Order  queryOrderWithUserAndDetailItemByOrderNumber(@Param("number") String number);
}
