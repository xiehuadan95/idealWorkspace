package com.xie.dao.impl;

import com.xie.beans.Role;
import com.xie.dao.RoleDao;
import org.springframework.stereotype.Repository;

/**
 * @Author xiehu
 * @Date 2022/9/3 21:06
 * @Version 1.0
 * @Description
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Override
    public Role get(Integer id) {
        if(id==null){
            throw new NullPointerException();
        }
        return new Role();
    }

    @Override
    public void add(Role role) {
    if(role==null){
        throw new NullPointerException();
    }
    //数据库执行add

    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            throw new NullPointerException();
        }
    }

    @Override
    public void update(Role role) {
    if(role==null){
        throw new NullPointerException();
    }
    }
}
