package com.xie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author xiehu
 * @Date 2022/9/7 21:34
 * @Version 1.0
 * @Description
 */
@SpringBootApplication
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
       SpringApplication.run(OrderApplication.class, args);
    }

    /*@Bean
    @LoadBalanced //负载均衡器的注解 相当于有了一个负载均衡调用机制 默认采用轮询
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return restTemplate;

    }*/
}
