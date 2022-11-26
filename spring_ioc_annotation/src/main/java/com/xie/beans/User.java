package com.xie.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author xiehu
 * @Date 2022/8/30 22:39
 * @Version 1.0
 * @Description
 */
@Component
public class User {

    //@Value设置依赖注入的属性
    //除了可以写硬编码值 还可以写 ${} 获取外部资源文件的值、#{} 获取·spel表达式
    @Value("张飞")
    private String name;

    @Value("#{role.name}")
    private String roleName;

    @Value("${mysql.name}")
    private String brotherName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getBrotherName() {
        return brotherName;
    }

    public void setBrotherName(String brotherName) {
        this.brotherName = brotherName;
    }
}
