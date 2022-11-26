package study.jvm;

/**
 * @Author xiehu
 * @Date 2022/8/29 23:41
 * @Version 1.0
 * @Description 模拟栈内存溢出
 */
public class StackOverFlowTest {
    //-Xss默认1M 可以放19324多次调用
    static int count=0;
    static void redo(){
        count++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable t) {
            System.out.println(count);
            t.printStackTrace();

        }
    }
}
