package com.xie.service.impl;

import com.xie.beans.User;
import com.xie.dao.UserDao;
import com.xie.service.BaseService;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xiehu
 * @Date 2022/8/30 22:33
 * @Version 1.0
 * @Description 实现接口的时候通过泛型来控制相应的返回对象类型
 */
//@Service(value="userService")
    @Service
//    @Primary//设置注入的主要bean
public class UserServiceImpl implements UserService, BaseService<User> {
    @Autowired
    UserDao userDao;
    @Override
    public void getUser() {
        userDao.getUser();
    }

    @Override
    public User getBean() {
        return null;
    }
}
