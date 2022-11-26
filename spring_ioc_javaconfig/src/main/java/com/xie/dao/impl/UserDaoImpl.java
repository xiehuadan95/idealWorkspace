package com.xie.dao.impl;

import com.xie.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Author xiehu
 * @Date 2022/8/30 22:33
 * @Version 1.0
 * @Description
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("查询数据库");
    }
}
