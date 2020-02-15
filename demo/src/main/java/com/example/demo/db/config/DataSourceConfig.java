package com.example.demo.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 装载数据源配置信息,常规多数据源配置
 */
//@Configuration
public class DataSourceConfig {
    @Bean(name = "db2DataSource")
    @Qualifier("db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlDataSource")
    @Qualifier("mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
