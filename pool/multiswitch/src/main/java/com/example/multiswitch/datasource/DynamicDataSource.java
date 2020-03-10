package com.example.multiswitch.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式，动态获取数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static DynamicDataSource instance;
    private static byte[] lock = new byte[0];
    //存储已经实例化的数据源
    private static Map<Object,Object> dataSourceMap = new HashMap<Object, Object>();


    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        dataSourceMap.putAll(targetDataSources);
        super.afterPropertiesSet();//不加新数据源无法识别
    }

    public Map<Object,Object> getDataSourceMap(){
        return dataSourceMap;
    }
    public static synchronized DynamicDataSource getInstance(){
        if(instance == null){
            synchronized (lock){
                if (instance ==null){
                    instance = new DynamicDataSource();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }
}
