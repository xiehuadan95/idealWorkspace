package com.nacosConfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @Author xiehu
 * @Date 2022/9/10 15:22
 * @Version 1.0
 * @Description ribbon实现 负载均衡策略 不能被@ComponentScan扫描到 不然就会全局共享此配置 方法名一定要叫iRule
 */
//@Configuration
//@RibbonClients(value={
//        @RibbonClient(name = "stock-service",configuration = RibbonRandomRuleConfig.class)})
public class RibbonRandomRuleConfig {
    @Bean
    public IRule iRule(){
        System.out.println("自定义了一个负载均衡策略！");
        //配置了一个随机的负载均衡策略
        return  new RandomRule();
    }
}
