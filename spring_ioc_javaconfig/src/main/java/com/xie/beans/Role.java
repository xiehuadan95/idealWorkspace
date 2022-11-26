package com.xie.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @Author xiehu
 * @Date 2022/8/30 23:06
 * @Version 1.0
 * @Description
 */
//@Component
@Lazy //懒加载
@Scope("prototype") //默认singlton
public class Role {
    @Value("管理员role")
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
//    //生命周期的回调 初始化回调
//    @PostConstruct
//    public void init(){
//        System.out.println("初始化");
//    }
//    //生命周期 销毁回调
//    @PreDestroy
//    public void destory(){
//        System.out.println("销毁");
//    }
}
