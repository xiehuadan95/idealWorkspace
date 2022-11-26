package com.xie.interceptor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author xiehu
 * @Date 2022/9/10 22:41
 * @Version 1.0
 * @Description feign的自定义拦截器
 */
public class CustomFeignInterceptor implements RequestInterceptor {
    //声明一个日志记录器
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //Todo
        requestTemplate.header("xxx","xxx");
        requestTemplate.query("id","9");
//        requestTemplate.uri("/9");  //
        logger.info("feign拦截器！===");
    }
}
