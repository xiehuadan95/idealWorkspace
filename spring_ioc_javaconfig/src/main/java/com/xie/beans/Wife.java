package com.xie.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author xiehu
 * @Date 2022/9/1 10:23
 * @Version 1.0
 * @Description
 */
public class Wife {
    @Value("迪丽热巴")
    private String name;

    @Override
    public String toString() {
        return "Wife{" +
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
