package com.xie.beans;

/**
 * @Author xiehu
 * @Date 2022/8/27 23:13
 * @Version 1.0
 * @Description
 */
public class Wife {
    private Integer age;
    private String name;

    public Wife() {
        System.out.println("========Wife已加载========");
    }

    @Override
    public String toString() {
        return "Wife{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
