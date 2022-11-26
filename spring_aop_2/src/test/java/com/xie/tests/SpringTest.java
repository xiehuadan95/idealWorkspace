package com.xie.tests;

import com.xie.service.IUserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author xiehu
 * @Date 2022/9/4 15:40
 * @Version 1.0
 * @Description
 */
public class SpringTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:/spring.xml");
//        IUserService bean = ioc.getBean(IUserService.class);
        IUserService bean = (IUserService)ioc.getBean("userServiceImpl");
        System.out.println(bean.getClass());
        //class com.sun.proxy.$Proxy19 使用aop后 jdk生成的动态代理类 当被代理的类实现了接口会默认使用jdk代理 如果没有实现就会使用cglib
        bean.select(1);
//        bean.delete(null);
    }

}
