package com.example.logdemo.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 11:05 2020/3/11
 * @Modified By:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogTest {
    private Logger logger = LoggerFactory.getLogger(LogTest.class);


    @Test
    public void test(){
        if (logger.isTraceEnabled()){
            logger.trace("this is a trance log");
        }

        if (logger.isDebugEnabled()){
            logger.debug("this is a debug log");
        }

        if (logger.isInfoEnabled()){
            logger.info("this is a info log");
        }

        if(logger.isWarnEnabled()){
            logger.warn("this is a warning log");
        }
        if (logger.isErrorEnabled()){
            logger.error("this is a error log");
        }

    }

    @Test
    public void testTrance(){
        if (logger.isTraceEnabled()){
            logger.trace("this is a trance log");
        }
    }

    @Test
    public void testDebug(){
        if (logger.isDebugEnabled()){
            logger.debug("this is a debug log");
        }
    }

    @Test
    public void testInfo(){
        if (logger.isInfoEnabled()){
            logger.info("this is a info log");
        }
    }

    @Test
    public void testWarning(){
        if(logger.isWarnEnabled()){
            logger.warn("this is a warning log");
        }
    }

    @Test
    public void testError(){
        if (logger.isErrorEnabled()){
            logger.error("this is a error log");
        }
    }


}
