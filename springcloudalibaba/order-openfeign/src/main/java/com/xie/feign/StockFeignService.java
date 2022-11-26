package com.xie.feign;

import com.xie.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xiehu
 * @Date 2022/9/10 17:38
 * @Version 1.0
 * @Description openfeign 的实现使用  底层也是用的动态代理
 * name :指定调用rest接口所对应的服务名
 * path :指定调用rest接口所在的StockController指定的RequestMapping 如果没有就没
 * 2.增肌接口和方法
 */
//@FeignClient(name = "stock-service", path = "/stock") 拥有全局配置 以下为指定某个配置
@FeignClient(name = "stock-service", path = "/stock",configuration = FeignConfig.class)
public interface StockFeignService {
    //声明需要调用的rest接口对应的方法 直接复制
    @RequestMapping("/reduct")
    String reduct();

    }


    /*
    * @RestController
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
    *
    *
    * */

