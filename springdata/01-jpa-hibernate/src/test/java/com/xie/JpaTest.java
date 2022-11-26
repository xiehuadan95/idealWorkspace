package com.xie;

import com.xie.pojo.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @Author xiehu
 * @Date 2022/10/4 15:39
 * @Version 1.0
 * @Description JPA测试类
 */
public class JpaTest {
    EntityManagerFactory factory;

    //配置文件的读取解析
    @Before
    public void before() {
        //指定持久化单元的名称 用的哪种JPA实现方式的单元名,也可以多一个入参，来设置配置项，这里使用配置文件中的内容所以只有一个参数
        factory = Persistence.createEntityManagerFactory("hibernateJPA");
//        factory= Persistence.createEntityManagerFactory("openJPA");
    }

    //插入
    @Test
    public void testC() {
        //相当于hibernate的session，桥梁
        EntityManager entityManager = factory.createEntityManager();
        //得到事务
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = new Customer();
        customer.setCustName("张三");

        entityManager.persist(customer);
        tx.commit();
    }

    //查询 立即查询
    @Test
    public void testR() {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = em.find(Customer.class, 2L);
        System.out.println(customer);

        tx.commit();
    }

    //延时加载
    @Test
    public void testLazy() {
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = em.getReference(Customer.class, 1L);
        System.out.println("=======================");
        System.out.println(customer);
        tx.commit();
    }

    //修改
    @Test
    public void testU() {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = new Customer();
        customer.setCustName("王五");
        customer.setCustId(5L);
        //根据这个id先查询是否有这条记录，如果有变化，就会更新，如果把id 注释掉，会直接插入
        em.merge(customer);
        //不会先查询，直接会将id为5的进行更新
        String jpql = "UPDATE Customer set custName=:Name where custId=:id";
        em.createQuery(jpql)
                .setParameter("Name","李四")
                .setParameter("id",5L)
                .executeUpdate();
        //如果很复杂也可以直接用 SQL ,用表名，列名字段
        String sql = "UPDATE tb_customer set cust_name=:Name where id=:id";
        em.createNamedQuery(sql)
                .setParameter("Name","王五")
                .setParameter("id",4L)
                .executeUpdate();

        tx.commit();
    }
    //删除
    @Test
    public void testD(){
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//        Customer customer = new Customer();
//        customer.setCustId(5L);
        Customer customer = em.find(Customer.class, 5L);
        //只能删除持久化状态的对象 所以要先查询出来 再删
        em.remove(customer);
        tx.commit();
    }
    //一级缓存 测试
    @Test
    public void testCacheI(){
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //这里只会查一次
        Customer customer = em.find(Customer.class, 1L);
        Customer customer2 = em.find(Customer.class, 1L);

        tx.commit();
    }

}
