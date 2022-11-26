package com.xie.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/9/3 14:17
 * @Version 1.0
 * @Description 实现类 所有被代理类的所有方法 都会经过这个invoke方法 如果返回null输出的就是null，输出的结果就是最终结果
 */
public class MyInvocationHandler implements InvocationHandler {

    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null && args.length > 0) {
            System.out.println("日志：调用了add方法，执行方法的参数是" + Arrays.asList(args));
        }else {
            System.out.println("日志：没有参数-----");
        }

        //执行被代理的真正的方法
        /* 被代理的对象 Object target
           被代理的方法的参数
         */
        Object res = method.invoke(target, args);

        System.out.println("日志：返回值" + res);
        return res;
    }
}
