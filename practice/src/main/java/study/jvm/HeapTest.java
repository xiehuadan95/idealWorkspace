package study.jvm;

import java.util.ArrayList;

/**
 * @Author xiehu
 * @Date 2022/8/29 23:56
 * @Version 1.0
 * @Description 堆内存溢出示例
 */
public class HeapTest {
    byte[] a=new byte[1024*100]; //100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heepList = new ArrayList<>();
        while(true){
            heepList.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
