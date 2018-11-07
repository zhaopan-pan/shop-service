package com.imooc.huayujun.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//和前端做交互
@ControllerAdvice
public class GlobalExceptionHandler {

    //统一异常处理
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){

        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }
}
