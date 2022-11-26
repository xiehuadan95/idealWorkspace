package study.jvm;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @Author xiehu
 * @Date 2022/8/25 21:55
 * @Version 1.0
 * @Description
 */
public class JDKClassLoader {
    public static void main(String[] args) {
        //获取String 这个核心类的加载器
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(JDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println("=================");
        //应用程序类加载器，扩展类加载器，引导类加载器 存在 parent属性 父类加载器，但不代表继承关系
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassloader.getParent();
        //引导类加载器是 C++语言实现的所以是null 其他两个都有名字
        System.out.println("the bootstrapLoader :" + bootstrapLoader);
        System.out.println("the extClassLoader :" + extClassloader);
        System.out.println("the appClassLoader :" + appClassLoader);

        System.out.println("===bootstrapLoader加载以下文件===============");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i]);
        }

        System.out.println("extClassLoader加载以下文件-================");
        //ext扩展类文件夹下
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("appClassLoader加载以下文件=================");
        //环境变量这个路径下去找
        System.out.println(System.getProperty("java.class.path"));


    }
}
