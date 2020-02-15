package com.example.demo.db;

import com.example.demo.DemoApplication;
import com.ibm.db2.jcc.am.SqlException;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DBTest {
    @Resource(name = "db2DataSource")
    private DataSource db2DataSource;
    @Resource(name = "mysqlDataSource")
    private DataSource mysqlDataSource;

    @Test
    public void testPrimaryDataSource(){

        try(Connection connection = db2DataSource.getConnection()){
            log.info("db2DataSource"+connection.getMetaData().getURL());
            boolean closed = connection.isClosed();
            Assert.assertFalse(closed);
            //插入数据
            insert(connection);
            //查询数据
            select(connection);
            //删除数据
            delete(connection);
        }catch (SQLException e){
           log.error(e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable:suppressed
                 ) {
                log.error(throwable.getMessage());
            }
        }

    }

    /**
     * 删除数据
     * @param connection
     */
    private void delete(Connection connection) {
        String delete = "delete from demo.user";
        try(Statement statement = connection.createStatement();
        ){
            int i = statement.executeUpdate(delete);
            log.info("删除数据行数："+i);
        }catch(SQLException e){
            throw new RuntimeException("删除数据异常",e);
        }
    }

    /**
     * 插入数据
     * @param connection
     */
    private void select(Connection connection) {
        String select = "select * from demo.user";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
        ){
            while (resultSet.next()){
                //获取元表信息
                ResultSetMetaData metaData = resultSet.getMetaData();
                StringBuilder stringBuilder = new StringBuilder("[");
                for(int i=0;i<metaData.getColumnCount();i++){
                    stringBuilder.append(metaData.getColumnName(i+1));
                    stringBuilder.append(":");
                    stringBuilder.append(resultSet.getObject(i+1));
                    stringBuilder.append(",");
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.append("]");
                log.info(stringBuilder.toString());
            }
        }catch (SQLException e){
            throw new RuntimeException("查询Sql异常",e);
        }
    }

    /**
     * 插入数据
     * @param connection
     */
    private void insert(Connection connection) {
        String insert = "insert into demo.user (name, gender, age, status, remark) " +
                "values(?,?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(insert)){
            statement.setString(1,"王肖辉");
            statement.setInt(2,1);
            statement.setInt(3,26);
            statement.setInt(4,0);
            statement.setString(5,"河南淮阳");
            statement.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("插入数据异常",e);
        }
    }

    @Test
    public void testSlaveDataResource(){
        try(Connection connection = mysqlDataSource.getConnection()){
            boolean closed = connection.isClosed();
            Assert.assertFalse(closed);
            log.info("mysqlDataSource"+connection.getMetaData().getURL());
        }catch(SQLException e){
            log.error(e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable:suppressed
                 ) {
                log.error(throwable.getMessage());
            }
        }
    }

    @Test
    public void testLogLevel(){
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");
    }
}
