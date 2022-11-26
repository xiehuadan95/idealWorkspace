package practice.practice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/9/3 20:46
 * @Version 1.0
 * @Description 增强日志工具类 用于AOP  将此类声明为切面了
 */
@Aspect
@Component //交给spring 管理才会生效
public class LogUtil {
    public static void before(Method method, Object[] args) {
        System.out.println(method.getName()+"方法运行前，参数是："+
                args==null?"": Arrays.asList(args));
    }
    public static void after(Method method, Object[] args) {
        System.out.println(method.getName()+"方法运行后，参数是："+
                args==null?"": Arrays.asList(args));
    }
    public static void afterException(Exception ex){
        System.out.println("方法报错了:"+ex.getMessage());
    }
    public static void afterEnd(){
        System.out.println("方法正常返回");
    }


}
