package com.imooc.huayujun.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
//开启事务管理
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer{

    @Autowired
    private DataSource dataSource;
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        //创建一个DataSourceTransactionManager的bean，同时注入dataSource的成员变量
        return new DataSourceTransactionManager(dataSource);
    }
}
