package com.xie;

import com.alibaba.druid.pool.DruidDataSource;
import com.xie.beans.MyImportBeanDefinitionRegistrar;
import com.xie.beans.Role;
import com.xie.beans.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @Author xiehu
 * @Date 2022/8/31 22:59
 * @Version 1.0
 * @Description 用这个类代替xml文件 将java的实体对象交给spring管理
 */
//用于标记一个spring配置类,之前是根据xml来启动spring上下文，现在根据这个类来启动spring上下文
 //相当于xml文件，同样也要去扫描包
@Configuration
@ComponentScan(basePackages = "com.xie") //相当于 <context:component-scan base-package="com.xie" use-default-filters="true">
//可以引入外部属性资源文件 同时value是数组 可以用多个
@PropertySource("classpath:db.properties")
//引入其他的配置文件，引入配置类 依然用import 也可以将类引入，注册为bean
//可以导入ImportSelector实现类，可以注册多个bean 重要
//导入ImportBeanDefinitionRegistrar实现类，可以注册多个beanDefinition
@Import({SecondJavaConfig.class,Role.class, MyImportBeanDefinitionRegistrar.class}) //这作为主配置类
public class IocJavaConfig {

    @Value("${mysql.username}")
    private String name;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.driverClassName}")
    private String driverClassName;


    //配置一个第三方的bean 可以干预Bean实例化的过程
    //bean的id就是这个方法的名字  返回的这个对象，就是bean的类型 不能是void 是void不反回内容 就是null
    //可以将一个类的实例 注册为一个bean
    //bean注解也可以设置name 为bean的id 也可以设置多个，是个数组
    @Bean(name={"dataSource","dd","123"})  //怎么依赖外部bean 自动注入依赖，直接再方法里面写上需要依赖的参数即可 不需要Autowired
    public DruidDataSource dataSource(Role  role){
        DruidDataSource dataSource=new DruidDataSource();
        //这里依然可以通过${}方式获取资源文件的值
        dataSource.setName(name);
        dataSource.setPassword(password);
        dataSource.setUrl("dbc:mysql://localhost:3306/test");
        dataSource.setDriverClassName(driverClassName);
        System.out.println(name+"password:"+password);
        System.out.println(role);

        System.out.println("自动注入依赖一个内部bean:"+user3());
        return dataSource;
    }

/*    @Bean(name="role")
//    @Scope("prototype") 设置作用域
    public Role role(){
        Role role = new Role();
        role.setName("哈哈怪");
        return role;
    }*/

    @Bean
    public User user3(){
        return new User();
    }


}
