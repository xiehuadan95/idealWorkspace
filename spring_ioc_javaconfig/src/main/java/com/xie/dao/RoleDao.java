package com.xie.dao;

import com.xie.beans.Role;

/**
 * @Author xiehu
 * @Date 2022/9/3 21:05
 * @Version 1.0
 * @Description
 */
public interface RoleDao {
    Role get(Integer id);
    void add(Role role);
    void delete(Integer id);
    void update(Role role);
}
