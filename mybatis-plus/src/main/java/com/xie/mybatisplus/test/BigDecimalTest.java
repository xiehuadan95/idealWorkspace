package com.xie.mybatisplus.test;

import com.xie.mybatisplus.dao.User;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BigDecimalTest {
    public static void main(String[] args) {
//        BigDecimal b1 = new BigDecimal("123");
//        BigDecimal b2 = new BigDecimal("122.99");
//        BigDecimal bb=new BigDecimal(0.00);
//        System.out.println("b2为："+b2);
//        bb=new BigDecimal("123");
//        System.out.println("bb="+bb);
//        BigDecimal b3=b1.subtract(b2);
//
//        System.out.println("加法"+b1.add(b2));
//        System.out.println(b3);
//        int i = b1.compareTo(b2);
//        System.out.println("谁大？结果"+i+"等于1吗？"+(i==1));
//        double d1 = Double.parseDouble("123");
//        double d2 = Double.parseDouble("122.99");
//        double d3=d1-d2;
//
//        System.out.println(d3);
        User user = new User();
        User user1 = new User();
        User user2 = new User();
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.stream().collect(Collectors.toList()).stream().forEach(iteam->iteam.setName("rose"));
        users.forEach(System.out::println);


    }
}
