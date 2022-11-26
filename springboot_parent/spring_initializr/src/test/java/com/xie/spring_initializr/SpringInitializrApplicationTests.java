package com.xie.spring_initializr;

import com.xie.spring_initializr.beans.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
//@TestPropertySource("classpath:appSource.properties")
class SpringInitializrApplicationTests {
    /* @Value("${server.port}")
     private String port;*/
//可以通过 @Value+SPEL表达式直接绑定配置文件中的值
    @Autowired
    User user;
    @Test
    void contextLoads() {
        HashMap<String, String> map = new HashMap<>();
            map.put("1","abc");
        System.out.println(map);
        map.put("1","abcd");
        System.out.println(map);

    }

}
