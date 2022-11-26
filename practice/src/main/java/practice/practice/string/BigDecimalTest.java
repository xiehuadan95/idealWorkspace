package practice.practice.string;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author xiehu
 * @Date 2022/6/10 17:17
 * @Version 1.0
 * @Description BigDecimal类型数据的相互转换 及使用
 */
public class BigDecimalTest {
    //正常数字 转为BigDecimal ，并计算，String转BigDecimal
    @Test
    public void strBigNum() {
        double num = 0.12;
        Double num1 = 0.01;
        int num2 = 1456;
        //这样写会出错
        BigDecimal ans = new BigDecimal(num);
        System.out.println("错误方式：" + ans);
        //常用转换
        ans = BigDecimal.valueOf(num);
        System.out.println(ans);
        BigDecimal ans2 = BigDecimal.valueOf(num2);
        System.out.println("整数转为BigDecimal:" + ans2);
        BigDecimal ans1 = new BigDecimal(num1.toString());
        System.out.println(ans1);
        //计算
        System.out.print("两个BigDecimal计算结果为：");
        BigDecimal res = ans.add(ans1);
        System.out.println(res);
        //转为String
        String resStr = res.toPlainString();
        System.out.println(resStr);
        String str = "0.1";
        String str1 = "1.2";
        String str2 = "23434.23";
        System.out.println(new BigDecimal(str));
        System.out.println(new BigDecimal(str1));
        System.out.println(new BigDecimal(str2));
        System.out.println("=======计算======");
        System.out.println(new BigDecimal(str).add(new BigDecimal(str1)).toPlainString());
    }
    //setScale（int newScale,RoundingMode roundingMode) 方法测试
    @Test
    public void testSetScale(){
        BigDecimal b = new BigDecimal("1.123");
        BigDecimal b1 = new BigDecimal("-1.105");
        BigDecimal b2 = new BigDecimal("0");
        BigDecimal b3 = new BigDecimal("1234.1250");
        //超过定义的保留位数，后面的数据按照四舍五入 方式，达到5 前一位进1
        System.out.println("=====保留两位小数，不够会补0====");
        BigDecimal ans = b.setScale(2, RoundingMode.HALF_UP);
        System.out.println(ans.toString());
        BigDecimal ans1 = b1.setScale(2, RoundingMode.HALF_UP);
        System.out.println(ans1.toPlainString());
        BigDecimal ans2= b2.setScale(2, RoundingMode.HALF_UP);
        System.out.println(ans2.toString());
        BigDecimal ans3 = b3.setScale(2, RoundingMode.HALF_UP);
        System.out.println(ans3);
        System.out.println("-----保留两位小数，不够会补0-----");
    }

    @Test
    public void testToStr(){
        String num="23829487938923598976554433989.23";
        BigDecimal target = new BigDecimal(num);
        System.out.println(target);
        System.out.println(target.toPlainString());
        System.out.println(target.toString());
        System.out.println(target+"");

    }
}
