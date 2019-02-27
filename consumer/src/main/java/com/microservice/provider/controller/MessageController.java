package com.microservice.provider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/message")
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("getMessage")
    @ResponseBody
    public JSONObject getMessage(){
        JSONObject json = new JSONObject();
        System.out.println("message");
        json.put("json","json");

        ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity("http://provider-message/message/getProviderMessage", JSONObject.class);
        JSONObject body = forEntity.getBody();
        json.put("message",body);
        System.out.println(json.toJSONString());
        return json;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://localhost:8890/message/getProviderMessage", Object.class);
        Object body = forEntity.getBody();
        JSONObject jsonObject = (JSONObject) JSON.toJSON(body);
        System.out.println(jsonObject);
    }
}
