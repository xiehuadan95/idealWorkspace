package practice.practice.singleton;

/**
 * 双重校验锁 DCL（DoubleCheckLock）
 * 必须加volatile 防止指令重排
 * 多线程情况下安全
 */
public class DCLType {
    // 增加volatile修饰禁止指令重排
    private static volatile DCLType INSTANCE;
    private DCLType() {
    }
    //可以整个方法加锁 但此时锁粒度太粗了，所以可降低锁粒度
    public static DCLType getInstance() {
        //进行了判断，如果有一个完成了new,就不用参与锁竞争，效率提高
        if (INSTANCE == null) {
            //如果等于空 进行上锁，上完锁再进行new 完了后释放锁
            //双重校验
            synchronized (DCLType.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new DCLType();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(DCLType.getInstance().hashCode());
            }).start();
        }
    }
}
