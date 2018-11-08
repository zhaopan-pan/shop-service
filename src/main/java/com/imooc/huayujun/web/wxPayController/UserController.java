package com.imooc.huayujun.web.wxPayController;

import com.alibaba.fastjson.JSONObject;
import com.imooc.huayujun.config.wxPay.WxPayConfig;
import com.imooc.huayujun.utils.HttpUtils;
import com.imooc.huayujun.utils.PayUtil;
import com.imooc.huayujun.vo.AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiang on 2017/12/10.
 */

@Controller
@RequestMapping("/Api/User/")
public class UserController {
    public static AccessToken token = null;         //微信公众号的accessToken对象，由于请求次数有限制，
    /**
     * @Description:微信支付
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/wxNotify")
    @ResponseBody
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        System.out.println("接收到的报文：" + notityXml);
        Map map = PayUtil.doXMLParse(notityXml);
        String returnCode = (String) map.get("return_code");
        if("SUCCESS".equals(returnCode)){
            //验证签名是否正确
            if(PayUtil.verify(PayUtil.createLinkString(map), (String)map.get("sign"), WxPayConfig.key, "utf-8")){
                /**此处添加自己的业务逻辑代码start**/
                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        System.out.println("微信支付回调数据结束");
        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

    @RequestMapping(value="/onLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> onLogin(String code){
        System.out.print("==============");
        System.out.print(code);
        Map<String,Object>result=new HashMap<>();
        String url=WxPayConfig.getSessionKeyUrl+"?appid="+ WxPayConfig.appId+
                "&secret="+WxPayConfig.secret+"&js_code="+code+"&grant_type="+WxPayConfig.grantType;
        JSONObject httpResult=HttpUtils.httpGet(url);
        if(httpResult!=null){
            result.put("openid",httpResult.get("openid"));
            result.put("session_key",httpResult.get("session_key"));
            result.put("expires_in",httpResult.get("expires_in"));
        }else{
            result.put("code",httpResult.get("-1"));
            result.put("msg",httpResult.get("获取openid失败"));
        }
        System.out.print(result);
        return  result;
    }
}
