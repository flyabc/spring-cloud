package com.microservice.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务提供者
 */
@EnableEurekaClient
//@EnableDiscoveryClient//开启发现服务功能
@SpringBootApplication
public class ConsumerBalancerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerBalancerApplication.class, args);

    }
    @LoadBalanced //使用负载均衡机制
    @Bean("myRestTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
