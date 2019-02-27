package com.microservice.provider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/balancer")
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    private LoadBalancerClient balancerClient;
    @Autowired
    public void setBalancerClient(LoadBalancerClient balancerClient) {
        this.balancerClient = balancerClient;
    }

    RestTemplate restTemplate;
    @Autowired
    @Qualifier("myRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/getMessage")
    @ResponseBody
    public JSONObject getMessage(){
        JSONObject json = new JSONObject();
        ServiceInstance choose = balancerClient.choose("provider-message");
        URI uri = choose.getUri();

        Map<String,Object> params = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        params.put("param","123456");
        JSONObject jsonObj = (JSONObject)JSON.toJSON(params);
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

        ResponseEntity<JSONObject> forEntity1 = restTemplate.getForEntity("http://provider-message/message/getProviderMessage?param=测试", JSONObject.class,params);
        ResponseEntity<JSONObject> stringResponseEntity = restTemplate.postForEntity("http://provider-message/message/getProviderMessage?param=成功", formEntity, JSONObject.class);


        JSONObject body1 = stringResponseEntity.getBody();
        //ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity("http://provider-message/message/getProviderMessage", JSONObject.class);
        JSONObject body = forEntity1.getBody();
        json.put("body",body);
        json.put("body1",body1);
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
