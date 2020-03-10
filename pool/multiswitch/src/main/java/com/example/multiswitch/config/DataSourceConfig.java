package com.example.multiswitch.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.multiswitch.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.example.multiswitch.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    @Bean(name = "db2DataSource")//配置数据源，mybatisDataSource为数据源自定义的名称
    @ConfigurationProperties(prefix = "spring.datasource.druid.two")
    public DataSource db2DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.one")
    public DataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
//    @DependsOn({"mysqlDataSource","db2DataSource"})
    public DynamicDataSource dynamicDataSource(@Qualifier("db2DataSource") DataSource db2DataSource, @Qualifier("mysqlDataSource") DataSource mysqlDataSource){
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("default",mysqlDataSource);
        map.put("master",db2DataSource);
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(mysqlDataSource);
        return dynamicDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/mapper/*.xml"));
        // 设置包别称
        bean.setTypeAliasesPackage("com.example.multiswitch.pojo");
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
