package com.xie;

import com.xie.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xiehu
 * @Date 2022/9/1 9:46
 * @Version 1.0
 * @Descriptionc 第二个javaConfig类，可以导入到第一个配置类中 这个配置类 只配置自定义的bean
 */
@Configuration
public class SecondJavaConfig {
    @Bean
    public User user2(){
        User user = new User();
        user.setName("劈裂小公司");
        user.setBrotherName("强尼");
        return  user;
    }

}
