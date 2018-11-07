package com.imooc.huayujun.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessionFactoryConfiguration {
    @Value("${mybatis_config_file}")
    private String mybatisConfiguration;

    @Value("${mapper_path}")
    private String mapperPath;

    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    //加别名，按照名字加载
    @Qualifier("dataSource")
    private DataSource dataSource;


    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //设置mybatis configuration配置文件的扫描路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfiguration));

        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        //指定mapper路径
        //CLASSPATH_ALL_URL_PREFIX(到项目根路径下面寻找相关的配置)
         String  packageSearchPath=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
         //根据路径读取相关配置
         sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));

         sqlSessionFactoryBean.setDataSource(dataSource);
         //指定实体类的扫描路径（映射实体类）
         sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);

        return sqlSessionFactoryBean;

    }
}
