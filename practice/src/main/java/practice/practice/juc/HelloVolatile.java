package practice.practice.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author eric
 * @Date 2022/5/3 22:51
 * @Version 1.0
 * @Description volatile的线程可见性测试
 */
public class HelloVolatile {
    //volatile修饰的 内存，如果有改变，其他线程会发现 如果不加 则running 修改了 线程t1也不会识别到
    volatile boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {
            //如果执行有打印语句，会系统打印会与内存做同步，此时会出现即使不加volatile 也出现停止的现象
            //System.out.println("hello");
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        HelloVolatile t = new HelloVolatile();
        //t1线程启动并调用m方法
        new Thread(t::m, "t1").start();
        //主线程睡了 1秒钟后，将running 改为false
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
