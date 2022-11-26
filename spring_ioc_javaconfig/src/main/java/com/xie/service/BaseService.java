package com.xie.service;

/**
 * @Author xiehu
 * @Date 2022/8/30 23:32
 * @Version 1.0
 * @Description 公共的接口 用泛型
 */
public interface BaseService<T> {
    T getBean();
    //公共的增删改查
}
