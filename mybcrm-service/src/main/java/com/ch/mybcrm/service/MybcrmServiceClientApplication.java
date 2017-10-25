package com.ch.mybcrm.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spring Boot Eureka Server 应用启动类
 *
 *
 * @author chenhao
 * @date 21/06/17
 */
// Eureka Server 标识
@EnableEurekaClient
// Spring Boot 应用标识
@SpringBootApplication()
//扫描Mapper接口
@MapperScan(value = {"com.ch.mybcrm.dao.mappers"})
public class MybcrmServiceClientApplication {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(MybcrmServiceClientApplication.class,args);
    }
}
