package com.xie.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author xiehu
 * @Date 2022/9/3 14:05
 * @Version 1.0
 * @Description JDK动态代理来完成 增加日志的功能 动态生成一个代理类 基于反射来完成的
 */
public class MyTest {
    //公共jdk动态代理对象生成
    public static Object createProxy(Object needProxy){

        ClassLoader classLoader = needProxy.getClass().getClassLoader();
        Class<?>[] interfaces =needProxy.getClass().getInterfaces();
        //传入被代理的对象
        InvocationHandler handler =new MyInvocationHandler(needProxy);

      //这里三个参数 得到一个代理类
        Object o =  Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println(o.getClass());

        return o;
    }

 /*   @Test
    public void test(){
        //创建代理类
        // ClassLoader loader 指定的被代理类的类/接口的类加载器,
        // Class<?>[] interfaces,指定被代理类的接口的类型
        // InvocationHandler h 委托执行的增强处理类，比如日志功能
        ClassLoader classLoader = ICalculator.class.getClassLoader();
        Class<?>[] interfaces =new Class[]{ICalculator.class};
        //用匿名 类实现这个方法
        *//*InvocationHandler handler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        };*//*
        InvocationHandler handler =new MyInvocationHandler(new Calculator());
        //这里要代理计算机这个类 三个参数 得到一个代理类
        ICalculator o = (ICalculator)Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println(o.getClass());
        //实际调用 执行add方法的时候，会执行handler里面委派的invoke方法 如果不写内容，会返回null
        System.out.println(o.add(1,2));
    }*/

}
