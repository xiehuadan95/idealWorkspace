package practice.practice.dataStructure;

import org.junit.Test;

/**
 * @Author xiehu
 * @Date 2022/5/31 10:55
 * @Version 1.0
 * @Description 阶乘 的运算
 */
public class Factorial {
    //阶乘的和 1！+2！+3！+...N！
    //最原始方法
    @Test
    public void sumTest() {
        //计算出一个数字的阶乘
        long meth = meth(4);
        System.out.println(meth);
        //N! 每个阶乘结果相加
        long sum = sum(4);
        System.out.println("最原始方法得到的阶乘和:"+sum); //33

    }
    //阶乘求和，优化
    @Test
    public void sumTest1(){
       long res=0;
       long start=1;
       int N =4;
        for (int i = 1; i <= N; i++) {
            start*=i;
            res+=start;
        }
        System.out.println("优化后的求和算法阶乘和："+res); //33
    }

    private long sum(int num) {
        long sum =0;
        for (int i = 1; i <= num; i++) {
            sum+=meth(i);
        }
        return sum;
    }

    //单个数字 阶乘计算 默认入参都大于0
    private long meth(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
