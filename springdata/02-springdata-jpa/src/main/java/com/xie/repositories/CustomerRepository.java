package com.xie.repositories;

import com.xie.pojo.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author xiehu
 * @Date 2022/10/5 10:29
 * @Version 1.0
 * @Description
 */
//继承这个类，需要指定泛型 需要操作的实体类 及id类型
public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
