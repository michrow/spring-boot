package com.example.demo.db.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.example.demo.db.dao.db2", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class Db2DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration configuration(){
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean(name = "db2DataSource")//配置数据源，mybatisDataSource为数据源自定义的名称
    @Primary//配置db2为mybatis默认数据源
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2DataSource() {
        return DataSourceBuilder.create().build();
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
//        bean.setVfs(SpringBootVFS.class);
        bean.setConfiguration(configuration);
//      设置映射文件
        bean.setMapperLocations(//classpath*:/mapper/db2/*Mapper.xml为指定数据源的sql配置路径
                new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/db2/*Mapper.xml"));
//      设置包别称
        bean.setTypeAliasesPackage("com.example.demo.db.pojo");
//      设置驼峰字段映射
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
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
