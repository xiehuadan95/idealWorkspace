package com.xie.mybatisplus.dao;

public class User {
    private String name ="jack";
    private int age=10;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+this.age;
    }
}
