package com.xie.dao.impl;

import com.xie.dao.IUserDao;
import com.xie.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author xiehu
 * @Date 2022/9/4 15:21
 * @Version 1.0
 * @Description  数据访问层实现类
 */
@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public User select(Integer id) {
        if(id==null){
            throw new NullPointerException("id 不能为 null");
        }
        //访问数据库查询user
        return new User();
    }

    @Override
    public void add(User user) throws Exception {
        if(user==null){
            throw new Exception("user 不能为 null");
        }

    }

    @Override
    public void update(User user) {
        if(user==null){
            throw new NullPointerException("user 不能为 null");
        }
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            throw new NullPointerException("id 不能为 null");
        }
    }
}
