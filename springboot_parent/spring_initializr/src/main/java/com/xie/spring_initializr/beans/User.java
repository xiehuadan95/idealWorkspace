package com.xie.spring_initializr.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @Author xiehu
 * @Date 2022/9/5 20:39
 * @Version 1.0
 * @Description 将资源文件的配置内容注入到对象之中
 *
 * @ConfigurationProperties 常用于bean属性和yml配置文件的 绑定
 * prefix 可以指定配置文件中某一个节点，该节点中的子节点将自动和属性进行绑定
 * 支持JSR-303数据校验：使用@Validated
 */
@Component
@Validated
@ConfigurationProperties(prefix = "user")
//@PropertySource("classpath:data/user.properties")
public class User {
    @Value("${user.username}")
    private String username;
    private Integer age;
    private Date birthday;
    private List<String> hobbies;
    private Map<Integer,String> girlFriend;
    //javax.validation.constraints.NotNull;
    @NotNull(message = "address地址不能为空")
    private Address address;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", hobbies=" + hobbies +
                ", girlFriend=" + girlFriend +
                ", address=" + address +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<Integer, String> getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(Map<Integer, String> girlFriend) {
        this.girlFriend = girlFriend;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
