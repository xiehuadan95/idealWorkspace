package com.xie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author xiehu
 * @Date 2022/10/5 10:43
 * @Version 1.0
 * @Description
 */
@Configuration   //标记为配置类
@EnableJpaRepositories
@EnableTransactionManagement
public class SpringDataJpaConfig {
}
