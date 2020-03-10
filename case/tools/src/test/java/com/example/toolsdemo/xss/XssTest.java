package com.example.toolsdemo.xss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 17:27 2020/3/10
 * @Modified By:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class XssTest {

    @Test
    public void test(){
        AntiSamy as = new AntiSamy();
        try{
            Policy policy = Policy.getInstance("antisamy.xml");
            CleanResults cr = as.scan("<div>wwwww<script>alert（1）</script></div>", policy);
            System.out.print(cr.getCleanHTML());
        }catch(Exception e) {
            e.printStackTrace();
        } ;
    }
}
