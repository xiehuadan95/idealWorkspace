package practice.practice.jvm;

import java.util.HashSet;

/**
 * @Author xiehu
 * @Date 2022/10/2 21:32
 * @Version 1.0
 * @Description
 */
public class Arthas {
    private static HashSet hashSet = new HashSet();
    public static void main(String[] args) {
        //模拟CPU过高
        cpuHigh();
        //模拟线程死锁
        deadThread();
        //不断的向hashSet 集合增加数量
        addHashSetThread();
    }
    /**
     * 不断的向 hashSet集合添加数据
     */
    private static void addHashSetThread() {
        //初始化常量
        new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    hashSet.add("count:" + count);
                    Thread.sleep(1000);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /**
     * 死锁
     */
    private static void deadThread() {
        //创建资源
        Object resourceA = new Object();
        Object resourceB = new Object();
        //创建线程
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + "get ResourceA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get ResourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + "get ResourceB");
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println(Thread.currentThread() + "get ResourceB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get ResourceA");
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + "get ReaourceA");
                }
            }
        });
        threadA.start();
        threadB.start();

    }

    /**
     * cpu过高
     */
    private static void cpuHigh() {
        new Thread(() -> {
            while (true) {

            }
        }).start();
    }
}
