package study.jvm;



/**
 * @Author xiehu
 * @Date 2022/8/25 0:01
 * @Version 1.0
 * @Description 探寻类加载过程
 */
public class TestDynamicLoad {  //会生成TestDynamicLoad.class文件
    //静态代码块
    static{ System.out.println("=========我是静态代码块=================="); }
    public static void main(String[] args) {
        //执行main方法 new A对象 此时加载A类，加载A的时候又会进行验证、准备、解析、初始化
        new A();
        System.out.println("*************load test************");
        B b = null; //B不会加载，除非这里执行 new B()

    }
}
class A{
    static{
        System.out.println("======== load  A ========");
    }
    public A(){
        System.out.println("========= initial A =============");
    }
}
class B{
    static{
        System.out.println("======== load  B ========");
    }
    public  B(){
        System.out.println("========= initial B =============");
    }
}
