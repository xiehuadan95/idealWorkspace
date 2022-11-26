package com.xie.pojo;

import javax.persistence.*;

/**
 * @Author xiehu
 * @Date 2022/10/3 21:56
 * @Version 1.0
 * @Description
 */
@Entity  //作为hibernate的实例
@Table(name = "tb_customer")  //映射的表名 会生成表
public class Customer {
    @Id //主键
    /**
     * 主键的生成策略 ：
     *     SEQUENCE ：序列，oracle 底层数据库必须支持序列
     *     IDENTITY：自增，mysql 底层数据库必须支持自动增长（对id自增）
     *     AUTO： 由程序自动的帮助我们选择主键生成策略
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cust_id") //对应的数据库字段名字
    private Long custId;  //主键

    @Column(name="cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }
}
