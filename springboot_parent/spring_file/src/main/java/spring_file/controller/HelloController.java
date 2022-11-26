package spring_file.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiehu
 * @Date 2022/9/5 10:55
 * @Version 1.0
 * @Description 控制类 hello
 */
@Profile("dev")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hi")
    public String sayHi(){
        return "Hello World!";
    }

    public HelloController() {
        System.out.println("初始化====加载====");
    }
}
