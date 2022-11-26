package practice.practice.thread;

/**
 * @Author xiehu
 * @Date 2022/10/19 16:17
 * @Version 1.0
 * @Description juc的多线程测试
 */
public class JUCtest{
    private static   int num=1;

    public static void main(String[] args) throws InterruptedException {
        Object locky =new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locky) {
                    for (int i = 0; i < 1000000; i++) {
                        num = num + 1;
                    }
                    System.out.println(Thread.currentThread().getName() + "结果为：" + num);
                }
            }
        });
        System.out.println("===============");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locky) {
                    for (int i = 0; i < 1000000; i++) {
                        num = num + 1;
                    }
                    System.out.println(Thread.currentThread().getName() + "结果为：" + num);
                }
            }
        });
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("运算结束====num为："+num);
    }

}
