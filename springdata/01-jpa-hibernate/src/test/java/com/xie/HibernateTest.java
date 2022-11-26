package com.xie;

import com.xie.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Author xiehu
 * @Date 2022/10/3 22:36
 * @Version 1.0
 * @Description
 */
public class HibernateTest {

    // Session工厂  Session:数据库会话  代码和数据库的一个桥梁
    private SessionFactory sf;
    //需要通过读取识别配置文件去构建解析
    @Before
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();

        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂

        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    //插入的操作
    @Test
    public void testC(){
        // session进行持久化操作 用try 包裹session 最后会自动关闭
        try(Session session = sf.openSession()){
            //开启事务
            Transaction tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustName("张三");
            customer.setCustAddress("天府三街");
            //基于对象 将数据保存起来
            session.save(customer);
            //提交事务
            tx.commit();
        }

    }


    @Test
    public void testR(){
        // session进行持久化操作
        try(Session session = sf.openSession()){
            Transaction tx = session.beginTransaction();
            //查询 直接查询出来
            Customer customer = session.find(Customer.class,1L);
            System.out.println("=====================");
            System.out.println(customer);

            tx.commit();
        }

    }

    @Test
    public void testR_lazy(){
        // session进行持久化操作
        try(Session session = sf.openSession()){
            Transaction tx = session.beginTransaction();
            //load 会进行懒加载 什么时候用到才会进行查询
            Customer customer = session.load(Customer.class, 1L);
            System.out.println("=====================");
            //此时用到了，才会执行查询操作
            System.out.println(customer);

            tx.commit();
        }

    }


    @Test
    public void testU(){
        // session进行持久化操作
        try(Session session = sf.openSession()){
            Transaction tx = session.beginTransaction();

            Customer customer = new Customer();
            //customer.setCustId(1L); 指定id
            customer.setCustName("李四");
            // 插入session.save()
            // 更新session.update();
            //如果存在会进行更新，如果不存在会新增 比如对象存在 主键id
            session.saveOrUpdate(customer);

            tx.commit();
        }

    }

    //删除
    @Test
    public void testD(){
        // session进行持久化操作
        try(Session session = sf.openSession()){
            Transaction tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustId(2L);
            session.remove(customer);

            tx.commit();
        }
    }


    @Test
    public void testR_HQL(){
        // session进行持久化操作
        try(Session session = sf.openSession()){
            Transaction tx = session.beginTransaction();
            //声明一个HQL 省略了[select] from +类名 +where +属性名
            String hql=" FROM Customer where custId=:id";
            //第一个参数 hql ,第二个参数为返回类型
            List<Customer> resultList = session.createQuery(hql, Customer.class)
                    //参数名字“id" ,值
                    .setParameter("id",1L)
                    .getResultList();
            System.out.println(resultList);
            tx.commit();
        }
    }
}

