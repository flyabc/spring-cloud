package com.microservice.provider.service;

import com.alibaba.fastjson.JSONObject;
import com.microservice.model.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="message-provider",path="/member",fallback =FeignImpl.class)
public interface FeignInterface {

    @GetMapping("/getProviderMessage")
    JSONObject hello(@RequestParam("name") String name);

    @GetMapping("/getList")
    List<Member> getList();

    @GetMapping("/getMemberById/{id}")
    Member getMemberById(@PathVariable String id);

    @RequestMapping(value="/updateById/{memberId}")
    Boolean updateById(@PathVariable String memberId, Member member);
}
