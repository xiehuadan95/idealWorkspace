package com.xie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xiehu
 * @Date 2022/9/7 21:34
 * @Version 1.0
 * @Description
 */
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
       SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced //负载均衡器的注解 相当于有了一个负载均衡调用机制 默认采用轮询
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return restTemplate;

    }
}
