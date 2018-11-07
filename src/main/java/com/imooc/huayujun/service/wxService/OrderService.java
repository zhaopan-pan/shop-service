package com.imooc.huayujun.service.wxService;

import com.imooc.huayujun.config.wxPay.WxPayConfig;
import com.imooc.huayujun.utils.WXPayUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiang on 2018/1/1.
 */

@Component
public class OrderService {

    //提交订单到微信
    public String commitData(String openId){
        String nonceStr= WXPayUtil.generateUUID();
        String body="JSAPI支付测试";
        Map<String, String> packageParams = new HashMap<String ,String>();
        packageParams.put("appid", WxPayConfig.appId);
        packageParams.put("body",body);
        packageParams.put("mch_id", WxPayConfig.mchId);
        packageParams.put("nonce_str",nonceStr);
        packageParams.put("notify_url", WxPayConfig.notify_url);//支付成功后的回调地址
        packageParams.put("openid",openId+"");//支付方式
        packageParams.put("out_trade_no", "12345678");//商户订单号
        packageParams.put("sign_type", WxPayConfig.signType);
        packageParams.put("spbill_create_ip","127.0.0.1");
        packageParams.put("total_fee", "1");//支付金额，这边需要转成字符串类型，否则后面的签名会失败
        packageParams.put("trade_type", WxPayConfig.tradeType);//支付方式
        String sign="";
        try {
            sign= WXPayUtil.generateSignature(packageParams, WxPayConfig.key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String formData = "<xml>";
        formData += "<appid>"+ WxPayConfig.appId+"</appid>"; //appid
        formData += "<body>" + body+ "</body>";
        formData += "<mch_id>"+ WxPayConfig.mchId+"</mch_id>"; //商户号
        formData += "<nonce_str>"+nonceStr+"</nonce_str>";
        formData += "<notify_url>"+ WxPayConfig.notify_url+"</notify_url>";
        formData += "<openid>"+openId+"</openid>";
        formData += "<out_trade_no>" + "12345678" + "</out_trade_no>";
        formData += "<sign_type>"+ WxPayConfig.signType+"</sign_type>";
        formData += "<spbill_create_ip>"+"127.0.0.1"+"</spbill_create_ip>";
        formData += "<total_fee>" + "1" + "</total_fee>";
        formData += "<trade_type>"+ WxPayConfig.tradeType+"</trade_type>";
        formData += "<sign>"+sign+"</sign>";
        formData += "</xml>";
        return formData;
    }
}
