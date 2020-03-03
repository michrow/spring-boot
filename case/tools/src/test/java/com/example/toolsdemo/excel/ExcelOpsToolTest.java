package com.example.toolsdemo.excel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExcelOpsToolTest {
    ExcelOpsTool excelOpsTool = ExcelOpsTool.getInstance();

    @Test
    public void createXls() {

        excelOpsTool.createXls();
    }

    @Test
    public void createXlsx() {

        excelOpsTool.createXlsx();
    }

    @Test
    public void readExcel(){
        excelOpsTool.readExcel("D:/temp/现有应用依赖和Spring Boot2.x依赖.xlsx");
    }
}