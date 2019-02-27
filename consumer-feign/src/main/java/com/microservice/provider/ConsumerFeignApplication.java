package com.microservice.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者
 */
@EnableFeignClients//或者@EnableEurekaClient注解//或者@EnableDiscoveryClient//开启发现服务功能
@EnableCircuitBreaker//或者@EnableHystrix注解,开启熔断器功能
@EnableHystrix
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class, args);
    }
    @LoadBalanced //使用负载均衡机制
    @Bean("myRestTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
