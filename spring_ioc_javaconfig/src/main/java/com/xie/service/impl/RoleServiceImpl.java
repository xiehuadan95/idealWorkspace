package com.xie.service.impl;

import com.xie.beans.Role;
import com.xie.dao.UserDao;
import com.xie.service.BaseService;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xiehu
 * @Date 2022/8/30 23:21
 * @Version 1.0
 * @Description
 */
public class RoleServiceImpl implements UserService, BaseService<Role> {
    @Autowired
    UserDao userDao;
    @Override
    public void getUser() {
        System.out.println("RoleServiceImpl");
        userDao.getUser();
    }

    @Override
    public Role getBean() {
        return null;
    }
}
