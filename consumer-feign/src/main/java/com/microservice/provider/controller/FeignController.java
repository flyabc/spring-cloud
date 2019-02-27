package com.microservice.provider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.microservice.model.entity.Member;
import com.microservice.provider.service.FeignInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/feign")
public class FeignController {
    private static final Logger logger = LoggerFactory.getLogger(FeignController.class);


    RestTemplate restTemplate;
    @Autowired
    @Qualifier("myRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    FeignInterface feignInterface;
    @Autowired
    public void setFeignInterface(FeignInterface feignInterface) {
        this.feignInterface = feignInterface;
    }


    @RequestMapping("/getMessage/{name}")
    @ResponseBody
    public JSONObject getMessage(@PathVariable("name") String name){
        JSONObject json = new JSONObject();
        JSONObject hello = feignInterface.hello(name);
        json.put("result",hello);
        return json;
    }
    @RequestMapping("/getList")
    @ResponseBody
    public JSONObject getMemberList(){
        JSONObject json = new JSONObject();
        List<Member> list = feignInterface.getList();
        json.put("list",list);
        return json;
    }

    @RequestMapping("/getMemberById/{id}")
    @ResponseBody
    public JSONObject getMemberById(@PathVariable("id") String id){
        JSONObject json = new JSONObject();
        Member member= feignInterface.getMemberById(id);
        json.put("member",member);
        return json;
    }

    @RequestMapping(value = "/updateById/{memberId}", produces = "application/json")
    @ResponseBody
    public JSONObject updateById(@PathVariable String memberId, Member member){
        JSONObject json = new JSONObject();
        System.out.println("***调用***"+member.toString());
        Boolean aBoolean = feignInterface.updateById(memberId, member);
        json.put("list",aBoolean);
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
