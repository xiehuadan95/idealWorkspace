package com.xie.service.impl;

import com.xie.dao.IUserDao;
import com.xie.entity.User;
import com.xie.service.IUserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xiehu
 * @Date 2022/9/4 15:20
 * @Version 1.0
 * @Description user服务实现层
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;


    @Logger(name="用户的查询方法！")
    public User select(Integer id) {
        System.out.println("查询User");
        return userDao.select(id);
    }

    @Override
    public void add(User user) throws Exception {
        System.out.println("增加User");
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        System.out.println("更新User");
        userDao.update(user);
    }

    @Override
    public void delete(Integer id) {
        System.out.println("删除User");
        userDao.delete(id);
    }
}
