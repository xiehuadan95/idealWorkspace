package practice.practice.dataStructure.math;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author xiehu
 * @Date 2022/6/2 23:37
 * @Version 1.0
 * @Description Math.random()随机数，会产生[0~1)区间范围内的小数  左闭右开等概率返回
 * 因为计算机里小数有精度，所以0到1的小数是有穷尽的，所以才会 有等概率返回
 * （也可变为给条件 3~20等概率返回 求如何20~56等概率返回）可为[0~36]+20
 * 作为对数器的基础，可随机生成数据（数组），例如：去验证排序算法是否写错了，可自行进行对数。
 */
public class Random {
    //Math.random()方法 测试是否等概率返回
    @Test
    public void test() {
        int count = 0;
        int testTimes = 10000;
        double tar = 0.2;
        for (int i = 0; i < testTimes; i++) {
            //[0~1)之间小于0.4的概率应该为40%左右，小于0.9的概率为90%
            //只会产生0~0.1,0~0.2,0~0.3...0~0.999。
            if (Math.random() < tar) {
                count++;
            }
        }
        System.out.println("出现小于" + tar + "的概率为：" + (double) count / (double) testTimes);
        /*
        出现小于0.4的概率为：0.4005    出现小于0.5的概率为：0.4985   出现小于0.1的概率为：0.1027
        出现小于0.6的概率为：0.5989    出现小于0.7的概率为：0.6989
        出现小于0.8的概率为：0.8006    出现小于0.9的概率为：0.8977
         */
    }

    //Math.random() * 整数I 会等概率返回一个double数[0~I)
    //可转为int类型整数
    @Test
    public void testInt() {
        //[0~1)->[0~9)
        int k = 9;   //[0~8]
        //创建一个数组，将每个数出现的次数，放到对应的下标中，0出现的次数放0号位，1出现的次数放1号位
        int[] counts = new int[9]; //初始数组：[0, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println("初始数组：" + Arrays.toString(counts));
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * k);
            //返回了什么值，则对应位置上的值++
            counts[ans]++;
        }
        //遍历数组
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
        /*
        0这个数出现了1101次  1这个数出现了1090次  2这个数出现了1101次
        3这个数出现了1093次  4这个数出现了1132次  5这个数出现了1102次
        6这个数出现了1067次  7这个数出现了1132次  8这个数出现了1182次
         */
    }
    //返回[0~1) ,返回目标数x
    //正常返回数在[0~x)区间的概率为 x,在[0~x)区间内出现数的概率为 x的平方
    @Test
    public void testPow(){
        int count = 0;
        int testTimes = 10000;
        double tar = 0.2;
        for (int i = 0; i < testTimes; i++) {
            //[0~x)之间小于x的概率应该为x的平方
            if (xToXPower2() < tar) {
                count++;
            }
        }
        System.out.println("出现小于" + tar + "的概率为x的平方：" + (double) count / (double) testTimes);
        //Math.pow(double,2)返回此数的平方
        System.out.println(tar+"的平方为："+Math.pow(tar,2));
        /*
        出现小于0.4的概率为x的平方：0.1602   0.4的平方为：0.16000000000000003
        出现小于0.3的概率为x的平方：0.0922   0.3的平方为：0.09
        出现小于0.2的概率为x的平方：0.0392   0.2的平方为：0.04000000000000001
         */
    }

    private double xToXPower2() {
        //random一次出现[0~x)范围内的概率为x,random两次 且最大数依然在[0~x)范围内，则概率为x的平方。三次方一样。
        //如果用min则是另外一种情况，不在此范围的概率为1-x的平方，在此范围则是1-（1-x）平方
        return Math.max(Math.random(),Math.random());
    }
    //有一个1~5 随机整数等概率返回的方法
    //不改造此方法的情况下，得到[1~7]等概率随机返回
    @Test
    public void testQuestion(){
        //[1~5]
        que();
        //对[1~5]方法进行改造 等概率随机产生0,1,
        //que()方法得到1,2 新方法生成0，得到3重新进行随机取数，得到4，5，新方法生成1。[1,2,3,4,5]概率都为20%，不要3，1，2的概率为50%，4，5概率为50%
        //因为3不要了，出现3的概率平分给了出现1，2，4，5的情况，所以1，2出现的概率 和 4，5出现的概率都是50%
        int binaryDigit = fun();
        /* 如果能等概率得到0~6，都+1就能等概率得到[1~7]
         一个二进制位可得到[0~1] ,两个二进制位拼一起可以得到[0~3],三个二进制位拼一起可得到[0~7]
         每个二进制位都调用fun(),是相互独立的，所以得到 000~111 是等概率的 拼出来的东西都是等概率的1/8
         */
        //得到000~111 等概率 用位运算拼接
        int ans=fun2();
        //只要得到[0~6]等概率随机整数，同fun()一样的方法，只要得到7就重做
       int ans3= fun3();
       //最后一步 fun3()+1 就会等概率得到[1~7]
        int res= fun4();

    }
     //等概率得到[1~7]
    private int fun4() {
        return fun3()+1;
    }

    //得到[0~6]
    private int fun3() {
        int ans=0;
        do{
            ans=fun2();
        }while (ans==7);
        return ans;
    }

    //用位运算 拼接，将fun()随机出来的0，1无符号左移
    //等概率返回[0~7]
    private int fun2() {
        //左移2位 1位 不移
        return (fun()<<2) +(fun()<<1)+(fun());
    }

    //0,1等概率发生器
    private int fun(){
        //先生成随机整数[1~5]，如果为3继续生成，如果不是3才能出来
        int ans=0;
        do{
            ans = que();
        }while (ans==3);
        return ans < 3 ? 0 : 1;
    }
    //[1~5]等概率返回
    private int que() {
        return (int)(Math.random()*5)+1;
    }
    //测试随机返回[1~5]的整数方法
    @Test
    public void queTest(){
        int[] counts = new int[6];
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int ans=que();
            counts[ans]++;
        }
        //遍历数组
        for (int i = 0; i < 6; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
    }
    //测试等概率返回0 ，1
    @Test
    public void funTest(){
        int count=0;
        int testTimes=10000;
        for (int i = 0; i < testTimes; i++) {
            if(fun()==0){
                count++;
            }
        }
        System.out.println("出现0的概率为：" + (double) count / (double) testTimes);
        //出现0的概率为：0.5092
    }
    //测试改造后 [0~7]随机整数的概率
    @Test
    public void fun2Test(){
        int[] counts = new int[8];
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int ans=fun2();
            counts[ans]++;
        }
        //遍历数组
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
        /*
        0这个数出现了1240次  1这个数出现了1256次  2这个数出现了1249次
        3这个数出现了1294次  4这个数出现了1237次  5这个数出现了1217次
        6这个数出现了1269次  7这个数出现了1238次
         */
    }
    //验证[0~6]随机整数的概率
    @Test
    public void fun3Test(){
        int[] counts = new int[7];
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int ans=fun3();
            counts[ans]++;
        }
        //遍历数组
        for (int i = 0; i < 7; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
        /*
        0这个数出现了1426次   1这个数出现了1396次  2这个数出现了1436次
        3这个数出现了1478次  4这个数出现了1444次  5这个数出现了1396次  6这个数出现了1424次
         */
    }
    //验证等概率得到[1~7]
    @Test
    public  void fun4Test(){
        int[] counts = new int[8];
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int ans=fun4();
            counts[ans]++;
        }
        //遍历数组
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数出现了" + counts[i] + "次");
        }
        /*
        0这个数出现了0次  1这个数出现了1417次  2这个数出现了1458次 3这个数出现了1400次
        4这个数出现了1419次  5这个数出现了1451次 6这个数出现了1415次 7这个数出现了1440次
         */
    }
}
