package com.xie.config;

import com.xie.interceptor.feign.CustomFeignInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;

/**
 * @Author xiehu
 * @Date 2022/9/10 22:03
 * @Version 1.0
 * @Description @Configuration 使用 会将配置作用所有的服务提供方
 * 局部配置：如果只想对某一个服务进行配置，就不要家@Configuration  2.通过配置文件 直接指定（常用）
 *
 */
//@Configuration   如果不加 就需要在feign的接口里面 进行指定引入此类作为配置
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){

        return Logger.Level.FULL;
    }
    //超时时间配置
    @Bean
    public Request.Options options(){
        return new Request.Options(5000,10000);
    }
    //让自定义拦截器生效
    @Bean
    public CustomFeignInterceptor customFeignInterceptor(){
        return new CustomFeignInterceptor();
    }
}
