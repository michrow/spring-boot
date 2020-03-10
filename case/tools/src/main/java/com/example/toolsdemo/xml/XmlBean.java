package com.example.toolsdemo.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.thoughtworks.xstream.converters.basic.BooleanConverter.YES_NO;


/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 15:29 2020/3/10
 * @Modified By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class XmlBean {

    private String name;

    private String addr;

    private boolean sex;
}
