package com.xie.beans;

/**
 * @Author xiehu
 * @Date 2022/8/28 15:54
 * @Version 1.0
 * @Description
 */
public class PersonFactory {
    public Person createPersonMethod(){
        Child child=new Child();
        child.setName("son2");
        return child;
    }
}
