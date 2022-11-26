package com.xie.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author xiehu
 * @Date 2022/9/3 20:46
 * @Version 1.0
 * @Description 增强日志工具类 用于AOP  将此类声明为切面了
 */
@Aspect
@Component //交给spring 管理才会生效
public class LogUtil {
    //前置通知
    // * 所有的方法 类路径service里面的 两个点代表子包及子分包 *所有的类的 所有的方法*(两个点所有的参数)
    @Before("execution(* com.xie.service..*.*(..))") //里面声明切点，要切入到哪个方法里面去 切点表达式
    public static void before() {
        System.out.println("方法前===========");
    }
    //后置通知
    @After("execution(* com.xie.service..*.*(..))")
    public static void after() {
        System.out.println("方法执行后====");
    }

    //后置异常通知
    @AfterThrowing("execution(* com.xie.service..*.*(..))")
    public static void afterException() {
        System.out.println("方法异常=====");
    }
    //后置返回通知
    @AfterReturning("execution(* com.xie.service..*.*(..))")
    public static void afterEnd() {
        System.out.println("方法正常返回后=========");
    }


}
