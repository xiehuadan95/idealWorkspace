package com.xie.controller;

import com.xie.feign.ProductFeignService;
import com.xie.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiehu
 * @Date 2022/9/7 21:30
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/order")
public class OrderController {
//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    StockFeignService stockFeignService;
    @Autowired
    ProductFeignService productFeignService;

    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功！");
//        String msg = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        String msg = stockFeignService.reduct();
        System.out.println("返回成功====");
        String p = productFeignService.get(1);
        return "hello Feign"+msg+"|商品查询的："+p;
    }
}
