package com.example.toolsdemo.commons;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 15:08 2020/3/10
 * @Modified By:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class LangToolsTest {
    @Test
    public void testStringUtils(){
        String str = null;
        String actual = StringUtils.defaultIfEmpty(str, "string");
        System.out.println(actual);
    }

    @Test
    public void testRandomStringUtils(){
        for (int i=0;i<5;i++){
            String random = RandomStringUtils.random(5, true, true);
            System.out.println(random);
        }
    }

    @Test
    public void testBuild(){
        LangBean bean = new LangBean("name", 12);
        System.out.println(bean);
    }

    @Test
    public void testArrayUtil(){
        int [] longArray = new int[] {1, 2, 3};
        String[] stringArray = new String[] {"中国", "人民", "java"};
        int[] clone = ArrayUtils.clone(longArray);
        int indexOfjava = ArrayUtils.indexOf(stringArray, "java");
        System.out.println(indexOfjava);
        ArrayUtils.reverse(clone);
        System.out.println(ArrayUtils.toString(clone));
    }
}
