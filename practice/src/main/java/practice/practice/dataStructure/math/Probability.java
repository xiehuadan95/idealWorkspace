package practice.practice.dataStructure.math;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/6/4 23:13
 * @Version 1.0
 * @Description 概率事件，给不等概率条件，得到等概率结果
 */
public class Probability {
    //给定一个函数，固定概率返回数值（非等概率）,具体概率不知道
    //要求不修改的前提下，得到某个等概率返回某数值的函数
    @Test
    public void test() {
        int[] arr = new int[2];
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int res = fun();
            arr[res]++;
        }
        System.out.println(Arrays.toString(arr));
        //[5013, 4987]  [4892, 5108]  [5007, 4993]

    }
    //只知道 会固定返回 0，1 但是具体概率多少 对外不暴露
    private int x() {
        return Math.random() < 0.77 ? 0 : 1;
    }
    /* 原理：x() 0概率 p 1的概率为 1-p ,x() 两次 出现 0 0的概率为 p*p 两次出现1概率为 (1-p)*(1-p)
       调用两次x(),出现0，1概率为 p*(1-p)  出现 1，0概率为 (1-p)*p 。此时这两种情况概率一样，则可设定
       0，1组合的时候 返回0，出现1，0组合的时候返回1，其他情况重新调用。此时 返回0 和 1的概率则为等概率
    */
    //需要改造得到的等概率返回的函数
    private int fun() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        //ans = 0 , 1  分开调用x(),第一次为0 ，第二次为1 跳出循环 如果是0 ， 0 继续x()
        //ans = 1 , 0  分开调用x(),第一次为1 ，第二次为0 跳出循环 如果是1 ， 1 继续x()
        //最后结果必为等概率
        //出现0，1状态 返回0 ，出现1 ,0状态返回1
        return ans;
    }
    //九九乘法表
    @Test
    public void test99(){
        for (int i = 1; i <= 9;i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
                if(i==j){
                    System.out.println();
                }
            }
        }
    }
    //单层循环实现99乘法表
   @Test
    public void test9(){
       for (int i = 1,j=1; i <9;i++) {
           System.out.print(j +"*"+i+"="+i*j+" ");
           if(i==j){
               System.out.println();
               j++;
               i=0;
           }
       }
   }
}
