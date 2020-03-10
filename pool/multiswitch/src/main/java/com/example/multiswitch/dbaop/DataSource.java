package com.example.multiswitch.dbaop;

import java.lang.annotation.*;

/**
 * 数据源注解
 */

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value() default DataSourceNames.ONE;
}
