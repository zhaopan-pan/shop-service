package com.imooc.huayujun.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

//@Configuration告诉spring初始化时需要来检索相关的bean
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.imooc.huayujun.dao")
public class DataSourceConfiguration {

    //读取并引入数据库连接信息
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    //在IOC里面注册一个bean
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        //生成datasource实例
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //设置驱动
        dataSource.setDriverClass(jdbcDriver);
        //连接地址
        dataSource.setJdbcUrl(jdbcUrl);
        //用户名
        dataSource.setUser(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        //连接池关闭时是否做提交
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }

}
