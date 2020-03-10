package com.example.multiswitch;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.multiswitch.datasource.DataSourceContextHolder;
import com.example.multiswitch.datasource.DynamicDataSource;
import com.example.multiswitch.pojo.Multitest;
import com.example.multiswitch.service.MultitestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MultiswitchApplication implements CommandLineRunner {

    @Autowired
    private MultitestService multitestService;

    @Autowired
    @Qualifier("dynmicds")
    private DruidDataSource dynmicds;



    public static void main(String[] args) {
        SpringApplication.run(MultiswitchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DataSourceContextHolder.setDBType("default");
        List<Multitest> multitests = multitestService.listMultitest();
        multitests.stream().forEach(multitest -> System.out.println(multitest.toString()));


//        DataSourceContextHolder.clearDBType();
        System.out.println("切换到db2数据库");
        DataSourceContextHolder.setDBType("master");
        List<Multitest> multitests1 = multitestService.listMultitest();
        multitests1.stream().forEach(multitest -> System.out.println(multitest.toString()));

        System.out.println("动态创建数据库");

        //创建数据库(一般动态创建都是通过读取数据库，本次为了简单，通过Bean注入)
//        DruidDataSource newDruidDataSource = createDataSource();
        //添加到数据库实例
        Map<Object, Object> dataSourceMap = DynamicDataSource.getInstance().getDataSourceMap();
        dataSourceMap.put("dynmicds",dynmicds);
        //更新数据源
        DynamicDataSource.getInstance().setTargetDataSources(dataSourceMap);

        System.out.println("切换到动态添加的数据库");
        DataSourceContextHolder.setDBType("dynmicds");
        List<Multitest> multitests2 = multitestService.listMultitest();
        multitests2.stream().forEach(multitest -> System.out.println(multitest.toString()));

    }
    @Bean(name = "dynmicds")
    @ConfigurationProperties(prefix = "spring.datasource.dynmicds")
    public DruidDataSource createDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
