package study.jvm;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author xiehu
 * @Date 2022/8/25 23:46
 * @Version 1.0
 * @Description 自定义类加载器
 */
public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader{
        private String classPath;
        public MyClassLoader(String classPath){
            this.classPath=classPath;
        }
        private byte[] loadByte(String name) throws IOException {
            name=name.replaceAll("\\.","/");
            FileInputStream fil = new FileInputStream(classPath + "/" + name + ".class");
            int len=fil.available();
            byte[] data = new byte[len];
            fil.read(data);
            fil.close();
            return data;
        }
        protected Class<?> findClass(String name)throws ClassNotFoundException{
            try{
                byte[] data=loadByte(name);
                //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组
                return defineClass(name,data,0,data.length);
            }catch (Exception e){
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoader myClassLoader = new MyClassLoader("F:/test");
        Class aClass = myClassLoader.loadClass("study.entity.Person");
        Object obj = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("method", null);
        method.invoke(obj,null);
        System.out.println(aClass.getClassLoader().getClass().getName());
    }
    //重写loadClass方法 打破双亲委派机制，实现自己的加载逻辑

   /* protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                try {
                    if (parent != null) {
                        c = parent.loadClass(name, false);
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }

                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }*/
}
