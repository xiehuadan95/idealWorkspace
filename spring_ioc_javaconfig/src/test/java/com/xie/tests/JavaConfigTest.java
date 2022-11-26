package com.xie.tests;

import com.xie.IocJavaConfig;
import com.xie.beans.Person;
import com.xie.beans.Role;
import com.xie.beans.Wife;
import com.xie.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author xiehu
 * @Date 2022/8/31 23:02
 * @Version 1.0
 * @Description
 */
public class JavaConfigTest {
    //加载上下文 根据javaConfig来加载 通过配置类来加载
    AnnotationConfigApplicationContext ioc;
    @Before
    public void before(){
        ioc=new AnnotationConfigApplicationContext(IocJavaConfig.class);
    }
    @Test
    public void test01(){
        UserController bean = ioc.getBean(UserController.class);
        bean.getUser();
    }

    @Test
    public void test02(){
//        DruidDataSource bean = ioc.getBean(DruidDataSource.class);
        Object bean = ioc.getBean("dataSource");
        System.out.println(bean);

        Object bean2 = ioc.getBean("dd");
        System.out.println(bean2);
        Object role = ioc.getBean("role");
        System.out.println(role);
    }
    //主配置类里面导入了第二个配置类 测试 user2
    @Test
    public void test03(){

        Object bean = ioc.getBean("user2");
        System.out.println(bean);
    }
    //在配置类中import
    @Test
    public void test04(){
        Role bean = ioc.getBean(Role.class);
        System.out.println(bean);
    }
    //实现了ImportSelector 导入选择器 的类 进行自动注入
    //只能根据类型来获取bean
    @Test
    public void test05(){
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean);
        Wife bean1 = ioc.getBean(Wife.class);
        System.out.println(bean1);
    }
    //bean定义的实现
    @Test
    public void test06(){
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean);
    }

}
