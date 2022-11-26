package com.xie.beans.test;

import com.xie.beans.Person;
import com.xie.beans.User;
import com.xie.beans.Wife;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author xiehu
 * @Date 2022/8/27 15:34
 * @Version 1.0
 * @Description 基于spring ioc.xml更高级使用
 */
public class IocHTest {
    ApplicationContext ioc;
    //公用的内容，所有的方法执行前都会执行
    @Before
    public void before() {
        //加入spring上下文 ApplicationContext是Spring IoC容器实现的代表，它负责实例化，配置 和组装Bean。
        //ClassPathXmlApplicationContext 根据项目路径的xml配置来实例化spring容器
        //FileSystemXmlApplicationContext 根据磁盘路径的xml配置来实例化spring容器 比如C盘 D盘上的某个文件
        //AnnotationConfigApplicationContext 根据注解
        ioc = new ClassPathXmlApplicationContext("spring-ioc-high.xml");
    }

    @Test
    public void test1() {
        System.out.println("Spring已加载bean====");
        Object bean = ioc.getBean("user", User.class);
    }
    @Test
    public void testLazy() {
        System.out.println("Spring已加载bean====");
        ioc.getBean("wife2", Wife.class);
    }
    /*
    作用域默认单例
     */
    @Test
    public void test2(){
        Person person = ioc.getBean("person", Person.class);
        Person person1 = ioc.getBean("person", Person.class);
        System.out.println(person);
        System.out.println(person1);
        System.out.println(person1==person);

    }
    //使用静态工厂方法实例化 不需要额外需要指定工厂
    @Test
    public void testFactory(){
        Person person = ioc.getBean("person2", Person.class);

        System.out.println(person);

    }
    //使用实例工厂方法实例化 需要额外指定 工厂及方法
    @Test
    public void testFactory2(){
        Person person = ioc.getBean("person3", Person.class);
        System.out.println(person);
    }
    //自动注入属性
    @Test
    public void testAuto(){
        Person person = ioc.getBean("person4", Person.class);
        System.out.println(person);
    }
}
