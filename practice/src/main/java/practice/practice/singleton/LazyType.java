package practice.practice.singleton;

/**
 * 懒汉式
 * 先定义一个对象，在需要的时候再new出来，按需加载
 * 多线程情况下会出现线程不安全的问题
 * 可通过双重校验锁方式解决线程不安全问题
 */
public class LazyType {
    //首先定义一个静态对象
    private static LazyType INSTANCE;
    //构造方法私有
    private LazyType() {
    }
    //统一对外提供的获取对象的方法
    public static LazyType getInstance() {
        if (INSTANCE == null) {
            //线程不安全，用睡眠一秒钟，代替有其他业务逻辑
            //此时多线程情况下，可能多个线程都判断为null进来，然后各自new对象
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new LazyType();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(LazyType.getInstance().hashCode())).start();
        }
    }
}
