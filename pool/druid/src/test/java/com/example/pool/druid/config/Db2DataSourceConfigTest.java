package com.example.pool.druid.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Db2DataSourceConfigTest {
    @Autowired
    private DataSource db2DataSource;

    @Test
    public void testGetConnect(){
//        Connection connection = null;
//        try {
//            connection = db2DataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if(connection!=null){
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//
//                }
//            }
//        }
    }

}
