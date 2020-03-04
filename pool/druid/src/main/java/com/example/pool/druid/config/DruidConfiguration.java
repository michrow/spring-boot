package com.example.pool.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class DruidConfiguration {
//    private static final Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);
//
//    @Bean
//    public ServletRegistrationBean registrationBean(){
//        logger.info("init Druid Servlet Configuration");
//
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        // Ip白名单
////        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
//        // Ip黑名单（优先级高于allow）
////        servletRegistrationBean.addInitParameter("deny","");
//        // 控制台用户名和密码
//        servletRegistrationBean.addInitParameter("loginUsername","admin");
//        servletRegistrationBean.addInitParameter("loginPassword","admin");
//        // 是否能够重置页面数据，禁用页面上的“Reset All ”
//
//        servletRegistrationBean.addInitParameter("resetEnable","false");
//        return servletRegistrationBean;
//    }
//    @Bean
//    public FilterRegistrationBean druidStatFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        // 添加过滤规则
//        filterRegistrationBean.addUrlPatterns("/*");
//        // 忽略过滤格式
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
//        return filterRegistrationBean;
//    }
}
