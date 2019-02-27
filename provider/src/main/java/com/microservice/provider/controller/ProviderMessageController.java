package com.microservice.provider.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/member",produces = "application/json; charset=utf-8")
public class ProviderMessageController {
    private static final Logger logger = LoggerFactory.getLogger(ProviderMessageController.class);

    @RequestMapping("getProviderMessage")
    @ResponseBody
    public JSONObject getMessage(String name){
        JSONObject json = new JSONObject();
        System.out.println("message");
        json.put("param",name);
        System.out.println(json.toString());
        return json;
    }
}
