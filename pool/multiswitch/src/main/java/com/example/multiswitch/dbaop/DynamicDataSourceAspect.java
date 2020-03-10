package com.example.multiswitch.dbaop;

import com.example.multiswitch.datasource.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

    /**
     * 切点：所有配置DataSource 注解的方法
     */
    @Pointcut("@annotation(com.example.multiswitch.dbaop.DataSource)")
    public void dataSourcePointCut(){}

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource ds = null;
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //获取自定义注解
        ds = method.getAnnotation(DataSource.class);
        if (ds == null){
            // 无注解使用缺省数据源
            DataSourceContextHolder.setDBType(DataSourceNames.ONE);
            log.info("set default datasource is "+DataSourceNames.ONE);
        }else{
            //如果使用了注解，则切换到指定数据源
            DataSourceContextHolder.setDBType(ds.value());
            log.info("set datasource is "+ ds.value());
        }
        return point.proceed();
    }

    @After(value = "dataSourcePointCut()")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDBType();
        log.info("clean datasource");
    }
}
