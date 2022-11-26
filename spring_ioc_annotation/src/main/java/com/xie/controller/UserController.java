package com.xie.controller;

import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author xiehu
 * @Date 2022/8/30 22:32
 * @Version 1.0
 * @Description 注解来实现ioc
 */
@Controller
public class UserController {

    /**
     * 使用@Autowired实现自动注入
     * byType  byName  默认优先根据类型去匹配
     * 如果匹配到多个类型，则会按照名字匹配按照userService去匹配
     * 如果名字也没有匹配到则会报错：
     * 1.改属性的名字 跟bean的名字对应上 这里实现了userService 有两个实现类 可改为 userServiceImpl
     * 2.改bean的名字 跟属性名字匹配上 @Service(value="userService") @Service("userService")
     * 3.注入属性增加一个注解 @Qualifier("userServiceImpl") 设置属性的名字（覆盖）
     * 4.  @Primary 设置注入的主要bean 当有多个的时候需要默认注入可这样设置
     * 5. 公共的接口，使用泛型作为自动注入限定符
     */
 //@Resource 优先根据名字匹配 依赖JDK  Autowired依赖spring  优先根据类型匹配
//    @Qualifier("userServiceImpl")
//            BaseService<User> userService;
  /*  @Autowired*/
    UserService userService;

    //可写在方法上 会根据参数名字去设置
    @Autowired
    public void createUserService( UserService userService){
        this.userService=userService;
    }
    public void getUser(){
        userService.getUser();
    }
}
