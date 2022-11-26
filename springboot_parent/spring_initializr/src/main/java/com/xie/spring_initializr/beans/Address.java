package com.xie.spring_initializr.beans;

/**
 * @Author xiehu
 * @Date 2022/9/5 20:42
 * @Version 1.0
 * @Description
 */

public class Address {
    private Integer id;
    private String desc;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
