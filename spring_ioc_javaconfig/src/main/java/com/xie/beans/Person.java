package com.xie.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author xiehu
 * @Date 2022/9/1 10:22
 * @Version 1.0
 * @Description
 */
public class Person {
    @Value("吴彦祖")
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
