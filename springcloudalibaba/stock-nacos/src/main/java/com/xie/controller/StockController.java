package com.xie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiehu
 * @Date 2022/9/7 21:32
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    String port;
    @RequestMapping("/reduct")
    public String reduct(){
        System.out.println("下单成功！==");
        return "扣减库存！"+port;
    }
}
