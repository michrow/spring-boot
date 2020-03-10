package com.example.toolsdemo.commons;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 15:13 2020/3/10
 * @Modified By:
 */
public class LangBean {
    private String name;
    private Integer age;

    public LangBean(String name,Integer age){
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
