package practice.practice.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 缺点：不管是否用到，类装在时就完成实例化
 */
public class HungryType {
    //类加载的时候即创建对象 常量不可修改
    private static final HungryType INSTANCE = new HungryType();
    //不允许其他人new对象，将构造方法私有化
    private HungryType() {
    }
    //对外提供一个方法获得对象
    public static HungryType getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        HungryType o = HungryType.getInstance();
        HungryType O1 = HungryType.getInstance();
        System.out.println(o == O1);
    }
}
