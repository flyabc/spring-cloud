package com.microservice.provider.controller;

import com.microservice.provider.entity.Member;
import com.microservice.provider.service.IMemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    IMemberService memberService;
    @Autowired
    public void setMemberService(IMemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    public void testGetList(){
        List<Member> list = memberService.list(null);
    }
}
