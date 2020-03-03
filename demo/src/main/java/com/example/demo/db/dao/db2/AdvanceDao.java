package com.example.demo.db.dao.db2;

import com.example.demo.db.pojo.Order;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据订单号查询订单信息及延时查询用户信息
     * @param number
     * @return
     */
    public Order queryOrderWithUserByOrderNumberLazy(@Param("number") String number);
}
