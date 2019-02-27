package com.microservice.provider.controller;


import com.microservice.provider.entity.Member;
import com.microservice.provider.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-02-15
 */
@RestController
@RequestMapping(value="/member",produces = "application/json;charset=utf-8")
public class MemberController {
    private final static Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Value("server.port")
    public String serverPort;

    IMemberService memberService;
    @Autowired
    public void setMemberService(IMemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List<Member> getList(){
        List<Member> list = memberService.list(null);
        System.out.println("list集合大小:"+list.size());
        return list;
    }
    @RequestMapping("/getMemberById/{id}")
    @ResponseBody
    public Member getMemberById(@PathVariable String id){
        return memberService.getById(id);
    }

    @RequestMapping("/updateById/{memberId}")
    @ResponseBody
    public Boolean updateById(@PathVariable String memberId, @RequestBody Member member){
        System.out.println("****************"+memberId);
        System.out.println("******************"+member.toString()+"************");
        return memberService.updateById(member);

    }
    @RequestMapping("/getTest")
    @ResponseBody
    public String getTest(){

        return serverPort;

    }
}
