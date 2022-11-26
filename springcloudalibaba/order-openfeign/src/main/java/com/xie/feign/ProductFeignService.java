package com.xie.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xiehu
 * @Date 2022/9/10 22:05
 * @Version 1.0
 * @Description
 */
@FeignClient(name="product-service",path = "/product")
//@FeignClient(name="product-service",path = "/product",configuration = FeignConfig.class)
public interface ProductFeignService {

    @RequestMapping("/{id}")
    String get(@PathVariable("id") Integer id);
}
