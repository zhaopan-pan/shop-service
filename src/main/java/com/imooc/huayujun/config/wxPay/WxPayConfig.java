package com.imooc.huayujun.config.wxPay;

public class WxPayConfig {
    //小程序appid
    public static final String appId="wxcc53ab401086580a";
    //微信支付的商户id
    public static final String mchId="1514907401";
    //小程序密钥
    public static final String secret="df27ecc1fc6075dc5d9cd7fb04f1ab49";
    //code 换取 session_key中类别
    public static final String grantType="authorization_code";
    //支付成功后的服务器回调url
    public static final String notify_url="https:www.wolzq.com/weixin/API/Order/notify";
    //微信支付的商户密钥
    public static final String key="xinshijie123456789XINSHIJIE12345";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String tradeType="JSAPI";
    //签名方式，固定值
    public static final String signType="MD5";
    //统一订单接口url地址
    public static final String createOrderUrl="https://api.mch.weixin.qq.com/pay/unifiedorder";
    //获取session_key和open_id的url地址
    public static final String getSessionKeyUrl="https://api.weixin.qq.com/sns/jscode2session";
}
