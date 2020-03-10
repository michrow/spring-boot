package com.example.toolsdemo.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 15:27 2020/3/10
 * @Modified By:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class XmlTest {

    @Test
    public void test(){
        XmlBean bean = new XmlBean("xml","string",true);
        XStream xStream = new XStream();
        String xml = xStream.toXML(bean);
        System.out.println(xml);
    }
    @Test
    public void testRename(){
        XmlBean bean = new XmlBean("xml","string",true);
        XStream xStream = new XStream();
        xStream.alias("package", XmlBean.class);
        xStream.aliasField("xmltag", XmlBean.class, "name");
        xStream.omitField(XmlBean.class, "addr");
        // 设置内置转换器
        xStream.registerConverter(BooleanConverter.YES_NO);
        String xml = xStream.toXML(bean);
        System.out.println(xml);
    }
}
