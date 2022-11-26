package practice.practice.dataStructure;

import org.junit.Test;

/**
 * @Author xiehu
 * @Date 2022/5/29 14:56
 * @Version 1.0
 * @Description 打印数字的位信息 数字底层都是二进制的
 */
public class NumPrint {
    //int底层32位底层信息组成  long底层是64位
    @Test
    public void printInt() {
        int intNum1 = 1;
        int intNum2 = 2;
        int intNum3 = 3;
        int intNum = 20958983;
        printI(intNum1);
        printI(intNum2);
        printI(intNum3); //00000000000000000000000000000011
        printI(intNum);
    }

    //位运算 左移位 及 &与运算，左移位都是无符号，只有右移才是有符号
    //数字左移一位，相当于num*2
    @Test
    public void testLeft() {
        //左移位运算 1向左移动31位，剩余的用0补上 比如 1<<31
        //1向左移动1位，剩余用0补全 为2
        System.out.println(1 << 1);
        //左移2位 位4
        System.out.println(1 << 2);
        System.out.println(1 << 31);
        // & 与运算
        System.out.println(2 & (1 << 0));
        //运算为：2的0次方+2的1次方+2的2次方，1只有一个1，2的0次方
        int num = 1;
        int num1 = 2345;
        printI(num);
        printI(num << 1);
        printI(num1);
        printI(num1 << 1);
    }

    //整型最大值及 正负数如何表示？32位最多能表示40多亿 2的32次方 -1;（因为0要算上，所以最大值要-1）
    //0归属在非负区域，负数最小值 绝对值能达到2的31次方，取反最后+1，就把符号位占用了。
    //实际上 int 最多是20多亿 2的31次方-1 ，因为有正负，如果无符号数，就可以都用了40多亿 ，所以无符号的最大值比有符号的最大值大
    @Test
    public void test() {
        //正型 真正表示值的范围是 0位到30位的范围，最高位留着既可以表示正，也可以表示负
        int max = Integer.MAX_VALUE;
        System.out.println(max); //2147483647
        printI(max);  //01111111111111111111111111111111
        //最高位是0 则此数肯定不是负数
        int min = Integer.MIN_VALUE;
        System.out.println(min);  //-2147483648
        printI(min);   //10000000000000000000000000000000
        System.out.println("01111111111111111111111111111111".length());
        //int的范围是 -2的31次方~2的31次方-1
        //如果是负数，符号位一定是1,符号位以外的数全部取反,末尾+1,则表示值是多少
        printI(-1);  //11111111111111111111111111111111 符号位以外的，全部取反1变为0...0;末尾+1以后的值 就为具体值；
        printI(-2);  //11111111111111111111111111111110
        printI(-3);  //11111111111111111111111111111101 全部取反为10000000000000000000000000000010 +1  ->10000000000000000000000000000011
    }

    //取反 ；负数的值就是 取反+1
    @Test
    public void test1() {
        int a = 1349811;
        //取反操作
        int b = -a;
        //打印32位数
        printI(a);  //00000000000101001001100010110011
        printI(b);  //11111111111010110110011101001101 全部相反，取反后+1则为值
        //取反操作+1 ，就是负的
        int b1 = (~a + 1);
        printI(b1); //11111111111010110110011101001101
        //整数最小数取反 及0取反
        System.out.println("===最小数取反+1及0取反是自己=====");
        int min = Integer.MIN_VALUE;
        printI(min);
        printI(~min); //取反
        //取反+1
        printI(~min + 1);
        printI(0);
        printI(-0);
        /*
        ===最小数取反+1及0取反是自己=====
        10000000000000000000000000000000
        01111111111111111111111111111111
        10000000000000000000000000000000
        00000000000000000000000000000000
        00000000000000000000000000000000
         */
    }

    //或 |  异或^
    @Test
    public void test2() {
        int a = 123;
        int b = 1340;
        printI(a);
        printI(b);
        System.out.println("===============");
        //两个数或运算，只要有一个地方有1，其他都变1
        printI(a | b);
        //两个位置都是1 才会出1，否则其他都是0
        printI(a & b);
        //两个位置相同 就为0 不同为1
        printI(a ^ b);

        /*00000000000000000000000001111011
          00000000000000000000010100111100
          ===============
          00000000000000000000010101111111
          00000000000000000000000000111000
          00000000000000000000010101000111*/
    }

    @Test
    public void testLong() {
        long start = System.nanoTime();
        long num1 = 1L;
        long num2 = 2L;
        long num = 123L;
        printL(num1);
        printL(num2);
        printL(num);
        long end=System.nanoTime();
        System.out.println(end-start);
     /*
     0000000000000000000000000000000000000000000000000000000000000001
     0000000000000000000000000000000000000000000000000000000000000010
     0000000000000000000000000000000000000000000000000000000001111011
     */
    }

    //打印64位信息 用与& 运算实现
    private void printL(long num) {
        for (int i = 63; i >= 0; i--) {
            System.out.print((num & (1L << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    //打印位 信息
    //从下标31开始进行与运算，如果num 与1左移31位后对比，如果是0 表示num的最第31位肯定为0，如果不是0，num的第31位为1 。
    private void printI(int num) {
        for (int i = 31; i >= 0; i--) {
            // & 与运算 （0与0，0与1相遇为0）
            //因为这个特性，左移位的数字与num与运算，如果不是1，则得到32位0，数值为0
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


}
