package com.xie.spring_initializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

//可自定义application
//@PropertySource("classpath:appSource.properties")
@SpringBootApplication
public class SpringInitializrApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication app =new SpringApplication(SpringInitializrApplication.class);
//        app.setDefaultProperties(); 可以加载外部的属性资源文件
        //关闭springBoot的启动横幅 可添加监听器之类
//        app.setBannerMode(Banner.Mode.OFF);
        //创建Properties

     /*   Properties properties = new Properties();
        //通过当前类的ClassLoader加载
        InputStream inputStream = SpringInitializrApplication.class.getClassLoader()
                .getResourceAsStream("app.properties");
        //将输入流读取成properties
        properties.load(inputStream);

        app.setDefaultProperties(properties);*/
        app.run(args);
    }

}
