package com.xie.service;

import com.xie.entity.User;

/**
 * @Author xiehu
 * @Date 2022/9/4 15:19
 * @Version 1.0
 * @Description
 */
public interface IUserService {
    User select(Integer id);
    void add(User user) throws Exception;
    void update(User user);
    void delete(Integer id);
}
