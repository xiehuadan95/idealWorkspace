package com.xie.productnacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiehu
 * @Date 2022/9/10 21:58
 * @Version 1.0
 * @Description
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/{id}")
    public String get(@PathVariable Integer id) throws InterruptedException {
        //模拟处理超时
        Thread.sleep(4000);
        System.out.println("查询商品id"+id);
        return "查询商品"+id+":"+port;
    }
}
