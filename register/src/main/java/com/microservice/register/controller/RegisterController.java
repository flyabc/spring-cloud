package com.microservice.register.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


@Controller
public class RegisterController {
    private final static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping("rest1/{param}/{name}")
    @ResponseBody
    public String restFul(@PathVariable("param") String username,@PathVariable("name") String paramName){
        System.out.println("param==="+username+",name==="+paramName);
        return "param==="+username+",name==="+paramName;
    }
    @RequestMapping("rest2/{param}")
    @ResponseBody
    public String restFul2(@PathParam("param") String param,@PathParam(value="name") String name){
        System.out.println("param==="+param+",name==="+name);
        return "param==="+param+",name==="+name;
    }
    @RequestMapping("rest3/{param}/{name}")
    @ResponseBody
    public String restFul3(@PathVariable String param,@PathVariable String name){
        System.out.println("param==="+param+",name==="+name);
        return "param==="+param+",name==="+name;
    }
    @RequestMapping("rest4/{name}")
    @ResponseBody
    public String restFul4(@QueryParam("param") String param, @PathVariable String name){
        System.out.println("param==="+param+",name==="+name);
        return "param==="+param+",name==="+name;
    }

}
