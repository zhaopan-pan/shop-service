package com.imooc.huayujun.vo;

/**
 * Created by qiang on 2017/12/14.
 */
public class OrderVO {
    private String openId;
    private String orderNo;
    private String payMoney;
    public OrderVO(){

    }

    public OrderVO(String openId, String orderNo, String payMoney) {
        this.openId = openId;
        this.orderNo = orderNo;
        this.payMoney = payMoney;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }
}
