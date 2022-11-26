package com.xie.beans.test;

import com.xie.beans.Person;
import com.xie.beans.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author xiehu
 * @Date 2022/8/27 15:34
 * @Version 1.0
 * @Description
 */
public class IocTest {
    ApplicationContext ioc;
    //公用的内容，所有的方法执行前都会执行
    @Before
    public void before() {
        //加入spring上下文 ApplicationContext是Spring IoC容器实现的代表，它负责实例化，配置 和组装Bean。
        //ClassPathXmlApplicationContext 根据项目路径的xml配置来实例化spring容器
        //FileSystemXmlApplicationContext 根据磁盘路径的xml配置来实例化spring容器 比如C盘 D盘上的某个文件
        //AnnotationConfigApplicationContext 根据注解
        ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
    }

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        System.out.println("Spring容器已加载");
        //通过类获取bean
//        User bean = ioc.getBean(User.class); //实例化一个对象 如同new  User();
        //通过bean的名字或者id获取bean
        User bean2 = (User) ioc.getBean("user");
        // User user = User.class.newInstance(); 并不是后面实例化的时候加载的
        //通过名字加上类型 如果配了两个user类，可以用这种方式 比较方便
        User bean3 = ioc.getBean("user", User.class);
//        System.out.println(bean);
        System.out.println(bean2);
        System.out.println(bean3);
    }
    @Test
    public void test2(){
        //通过别名也能获取到
        User zhangsan = ioc.getBean("zhangsan", User.class);
        System.out.println(zhangsan);
        Object user2 = ioc.getBean("user2");
        System.out.println(user2);
    }
    /*
    基于setter方法的依赖注入
     */
    @Test
    public void test3(){
        //通过别名也能获取到
        Object user = ioc.getBean("user4");
        System.out.println(user);
    }

    /**
     * 基于构造函数的依赖注入
     */
    @Test
    public void test4(){
        //通过别名也能获取到
        Object user = ioc.getBean("user5");
        System.out.println(user);
    }
    /**
     * 基于构造函数的依赖注入
     */
    @Test
    public void test5(){
        //通过别名也能获取到
        Person person = ioc.getBean("person",Person.class);
        System.out.println(person);
    }
}
