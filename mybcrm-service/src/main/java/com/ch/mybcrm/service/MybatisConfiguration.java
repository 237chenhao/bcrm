package com.ch.mybcrm.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by chenhao on 2017/10/24.
 */
//@ConfigurationProperties(prefix = "mybatis")
//@EnableTransactionManagement
//@EnableConfigurationProperties(value = {DataSourceConfiguration.class,MybatisConfiguration.class})
public class MybatisConfiguration {

    private String mapperLocations;
    private String configLocations;
    private String mappers;

    @Autowired
    private DataSource dataSource;

    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(ApplicationContext ac) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(new ClassPathResource(configLocations));

        //添加XML目录
        //ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //resolver.getResources("");
        bean.setMapperLocations(ac.getResources(mapperLocations));
        return bean.getObject();
    }

    @Bean
    @DependsOn("sqlSessionFactory")
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //扫描mapper接口
        mapperScannerConfigurer.setBasePackage(mappers);
        return mapperScannerConfigurer;
    }

}
