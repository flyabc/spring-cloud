package com.microservice.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.microservice.model.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class FeignImpl  implements FeignInterface{

    private final static Logger logger = LoggerFactory.getLogger(FeignImpl.class);

    @Override
    public JSONObject hello(@RequestParam String name) {
        return null;
    }

    @Override
    public List<Member> getList() {
        return null;
    }

    @Override
    public Member getMemberById(String id) {
        logger.info("接收到的id值为:"+id);
        return null;
    }

    @Override
    public Boolean updateById(String memberId, Member member) {
        logger.info("接收到的id值为:"+memberId+"member的值为:"+member.toString());
        return null;
    }
}
