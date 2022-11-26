package study.entity;

import practice.entity.User;

/**
 * @Author xiehu
 * @Date 2022/8/28 21:46
 * @Version 1.0
 * @Description 练习使用实体类
 */
public class Math {
    public static final int initData =666;
    public static User user=new User();

    public int compute(){
        int a=1;
        int b=2;
        int c=(a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        Math math=new Math();
        math.compute();
        System.out.println("test====");
    }
}
