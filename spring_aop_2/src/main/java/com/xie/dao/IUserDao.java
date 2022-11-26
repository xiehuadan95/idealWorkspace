package com.xie.dao;

import com.xie.entity.User;

/**
 * @Author xiehu
 * @Date 2022/9/4 15:20
 * @Version 1.0
 * @Description 数据访问层接口
 */
public interface IUserDao {
    User select(Integer id);
    void add(User user) throws Exception;
    void update(User user);
    void delete(Integer id);
}
