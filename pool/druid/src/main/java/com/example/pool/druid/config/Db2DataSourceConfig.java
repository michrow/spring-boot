package com.example.pool.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.pool.druid.mapper.db2", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class Db2DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration configuration(){
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean(name = "db2DataSource")//配置数据源，mybatisDataSource为数据源自定义的名称
    @Primary//配置db2为mybatis默认数据源
    @ConfigurationProperties(prefix = "spring.datasource.druid.two")
    public DataSource db2DataSource() {
        return DruidDataSourceBuilder.create().build();
//        return new DruidDataSource();
    }

    /**
     * 配置Session工厂
     *
     * @param dataSource
     * @return
     * @throws Exception mybatisSqlSessionFactory为session工厂自定义名称
     */
    @Bean(name = "db2SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource, org.apache.ibatis.session.Configuration configuration) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(configuration);
//      设置映射文件
        bean.setMapperLocations(//classpath*:/mapper/db2/*Mapper.xml为指定数据源的sql配置路径
                new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/db2/*Mapper.xml"));
//      设置包别称
        bean.setTypeAliasesPackage("com.example.pool.druid.pojo");
//      设置驼峰字段映射
//        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        bean.getObject().getConfiguration().setCacheEnabled(false);
        return bean.getObject();
    }

    /**
     * mybatis会用到的SqlSession模板
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "db2SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 数据源事务配置
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "db2TransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
