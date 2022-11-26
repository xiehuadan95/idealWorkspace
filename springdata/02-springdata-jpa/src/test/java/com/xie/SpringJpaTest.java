package com.xie;

import com.xie.pojo.Customer;
import com.xie.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * @Author xiehu
 * @Date 2022/10/5 10:31
 * @Version 1.0
 * @Description
 */
//基于junit4 spring单元测试
@ContextConfiguration(locations = "/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJpaTest {
    @Autowired
    CustomerRepository repository;

    //查询
    @Test
    public void testR() {
        Optional<Customer> byId = repository.findById(1L);
        System.out.println(byId.get());
    }

    //插入
    @Test
    public void testC() {
        Customer customer = new Customer();
        //  customer.setCustId(1l); 如果有id 则会进行更新 会先查询
        customer.setCustName("李四");
        repository.save(customer);
        // 底层会先查一遍 再删除
        repository.delete(customer);
    }
}
