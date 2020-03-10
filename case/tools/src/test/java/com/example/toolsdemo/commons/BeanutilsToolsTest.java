package com.example.toolsdemo.commons;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.commons.beanutils.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 13:51 2020/3/10
 * @Modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BeanutilsToolsTest {
    @Test
    public void testMethodUtils() throws Exception {
        UserBean userBean = new UserBean();
        Method method = MethodUtils.getAccessibleMethod(UserBean.class,"setUserName",String.class);
        method.invoke(userBean,"username");
        MethodUtils.invokeMethod(userBean,"setBirth",new Date());
        log.info(userBean.toString());
    }

    @Test
    public void testConstructorUtils() throws Exception{

//        Constructor<UserBean> accessibleConstructor = ConstructorUtils.getAccessibleConstructor(UserBean.class, new Class[]{String.class, String.class, Long.class,
//                Date.class, String.class});
//        UserBean userBean = accessibleConstructor.newInstance("userId", "username", 12l, new Date(), new String[]{"1", "2"});
//        log.info(userBean.toString());

        UserBean userBean1 = (UserBean) ConstructorUtils.invokeConstructor(UserBean.class, new Object[]{"userId1", "username1", 12l, new Date(), new String[]{"1", "2"}});
        log.info(userBean1.toString());
    }

    @Test
    public void testPropertyUtils() throws Exception{

        UserBean bean1 = new UserBean("userId1", "userName1");
        UserBean bean2 = new UserBean();
        PropertyUtils.copyProperties(bean2, bean1);
        log.info(bean2.toString());

        System.out.println(PropertyUtils.describe(bean1));
        PropertyUtils.setProperty(bean1, "number", 13l);
        log.info(bean1.toString());

    }

    @Test
    public void testBeanUtils() throws Exception{
        UserBean bean = new UserBean();
        Map<String,String> properties = new HashMap<String,String>();
        properties.put("userId", "userId");
        properties.put("userName", "userName");
        BeanUtils.populate(bean, properties);
        log.info(bean.toString());
    }
    @Test
    public void test() throws Exception{
        //注册类型转换器
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) value);
                } catch (ParseException e) {
                    log.error(e.getMessage());
                    return null;
                }
            }
        }, Date.class);

        System.out.println((ConvertUtils.convert("2020-02-09 13:00:00", Date.class)));
    }


}
