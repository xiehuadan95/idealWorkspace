package cn.tulingxueyuan.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Aspect   //声明为一个切面
@Component  //放ioc容器
public class LogUtil {

    // 前置通知
    // * 所有的方法 类路径service里面的 两个点代表子包及子分包 *所有的类的 所有的方法*(两个点所有的参数)
    //里面声明切点，要切入到哪个方法里面去 切点表达式
    @Before("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void before(){
       /* System.out.println(method.getName()+"方法运行前，参数是"+
                (args==null?"": Arrays.asList(args).toString()));*/

        System.out.println("方法前");
    }

    // 后置通知
    @After("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void after(){
       /* System.out.println(method.getName() +"方法运行后，参数是"+
                (args==null?"": Arrays.asList(args).toString()));*/
        System.out.println("方法后");
    }

    // 后置异常通知
    @AfterThrowing("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void afterException(){
       // System.out.println("方法报错了:"+ex.getMessage());

        System.out.println("方法异常");
    }

    // 后置返回通知
    @AfterReturning("execution(* cn.tulingxueyuan.service..*.*(..))")
    public static void afterEnd(){
        //System.out.println("方法结束，返回值是:"+returnValue);
        System.out.println("方法返回");

    }
}
