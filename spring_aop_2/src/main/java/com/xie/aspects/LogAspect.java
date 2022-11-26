package com.xie.aspects;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/9/4 15:57
 * @Version 1.0
 * @Description 切面类 增强日志功能  标记为切面 标记为bean组件 才能切入到ioc中的bean
 */
@Aspect
@Component
public class LogAspect {

    //表达式的抽取 这里声明了一个切点，其他地方对此切点进行引用
    @Pointcut("execution(public * com.xie.service.impl.*.*(..))")
    public void pointcut() {

    }

    //前置通知  切点表达式
//    @Before("execution(* com.xie.service.impl.*.*(Integer))") 切入到参数为Integer类型的方法
//    @Before("execution(public * com.xie.service.impl.*.*(..))")
    @Before("pointcut() && @annotation(logger)")
    //匹配方法上 标记了 jdk.nashorn.internal.runtime.logging.Logger 这个logger的注解 只需要将注解对应参数上面的名字，会自动根据参数类型去对应
    public void before(JoinPoint joinPoint, Logger logger) {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //所有的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知" + methodName + "[方法运行]，参数是：" + Arrays.asList(args) + "注解的值是：" + logger.name());

    }

    //后置通知
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //所有的参数
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName + "[方法运行]，参数是：" + Arrays.asList(args));
        System.out.println("最终通知====");
    }

    //后置异常通知
    @AfterThrowing(value = "execution(* com.xie.service.impl.*.*(..))",
            throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("后置异常通知====,异常为：" + ex);
        //获取异常的栈信息
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw, true));
        System.out.println("异常栈信息：" + sw.getBuffer().toString());
    }

    //后置返回通知 返回值不确定
    @AfterReturning(value = "execution(* com.xie.service.impl.*.*(..))",
            returning = "returnValue")
    public void afterReturning(Object returnValue) {
        System.out.println("后置返回通知====返回值为：" + returnValue);
    }

    //环绕通知
    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //所有的参数
        Object[] args = joinPoint.getArgs();
        //返回值
        Object returnValue="";
        try {
            System.out.println("环绕：前置通知->执行方法为====" + methodName + "参数为====" + Arrays.asList(args));
            returnValue=joinPoint.proceed();
            System.out.println("环绕：后置返回通知->执行方法为====" + methodName + "参数为====" + Arrays.asList(args));
        } catch (Throwable throwable) {
            System.out.println("环绕：后置异常通知->异常为====" + throwable);
            throwable.printStackTrace();
        }finally{
            System.out.println("环绕：最终通知->返回值为===="+returnValue);
        }
        System.out.println("环绕通知==结束==");


    }


}
