package com.example.multiswitch.datasource;

/**
 * 通过ThreadLocal维护一个全局map实现数据源的动态切换
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static synchronized void setDBType(String dbType){
        contextHolder.set(dbType);
    }

    public static Object getDbType() {
        return contextHolder.get();
    }

    public static void clearDBType(){
        contextHolder.remove();
    }
}
