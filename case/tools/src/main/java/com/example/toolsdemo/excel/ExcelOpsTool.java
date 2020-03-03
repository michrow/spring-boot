package com.example.toolsdemo.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelOpsTool {

    private static ExcelOpsTool excelOpsTool = null;

    public static ExcelOpsTool getInstance(){
        if(excelOpsTool == null){
            excelOpsTool = new ExcelOpsTool();
        }else{}
        return excelOpsTool;

    }

    /**
     * 创建excel xls
     */
    public void createXls(){

        String filePath = "D:/temp/text.xls";
        //  创建表格
        HSSFWorkbook workbook  =new HSSFWorkbook();
        //  创建sheet
        HSSFSheet sheet1 = workbook.createSheet("sheet1");

        HSSFRow row = sheet1.createRow(0);

        row.createCell(0).setCellValue(new Date());
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue(false);

        write(workbook,filePath);
    }

    /**
     * 读取  excel
     */
    public void readExcel(String filePath){
        //截取文件后缀，判断操作excel版本
        String suffix = filePath.substring(filePath.lastIndexOf("."));

        Workbook workbook = null;
        InputStream is = null;

        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(suffix)){
                workbook = new HSSFWorkbook(is);
            }else if (".xlsx".equals(suffix)){
                workbook = new XSSFWorkbook(is);
            }else {}

            if (workbook != null){
                // 获取第一个sheet
                Sheet sheet = workbook.getSheetAt(0);
                //获取行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                //获取第一行
                Row row = sheet.getRow(0);
                // 获取列数
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                for (int i = 0; i < physicalNumberOfRows; i++) {
                    row = sheet.getRow(i);
                    if (row != null) {
                        for (int j = 0; j < physicalNumberOfCells; j++) {
                            Object cellFormatValue = getMergedCellValue(sheet,i,j);
                            System.out.print(cellFormatValue+"  ");
                        }
                    } else {
                        break;
                    }
                    System.out.println();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {

                }
            }
        }


    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param column
     * @return
     */
    private Object getMergedCellValue(Sheet sheet,int row,int column){

        // 获取合并单元格数
        int numMergedRegions = sheet.getNumMergedRegions();
        for (int i = 0;i<numMergedRegions;i++){
            //获取第i个单元格
            CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
            //获取合并单元格的范围域
            int firstColumn = mergedRegion.getFirstColumn();
            int firstRow = mergedRegion.getFirstRow();
            int lastColumn = mergedRegion.getLastColumn();
            int lastRow = mergedRegion.getLastRow();

            if(row>=firstRow && row<=lastRow){
                if(column>=firstColumn && column<=lastColumn){
                    return getCellFormatValue(sheet.getRow(firstRow).getCell(firstColumn));
                }
            }
        }
        return  getCellFormatValue(sheet.getRow(row).getCell(column));
    }
    /**
     *获取单元格的值
     * @param cell
     * @return
     */
    private Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            // 判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    // 判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // 转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        // 数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }


    /**
     * 创建excel xlsx
     */
    public void createXlsx(){

        String filePath = "D:/temp/text.xlsx";

        //  创建表格
        XSSFWorkbook workbook  =new XSSFWorkbook();
        //  创建sheet
        XSSFSheet sheet1 = workbook.createSheet("sheet1");

        XSSFRow row = sheet1.createRow(0);
        row.createCell(0).setCellValue(new Date());
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue(false);

        write(workbook,filePath);
    }

    private void write(Workbook workbook,String filePath){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            //  保存文件
            workbook.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {

                }
            }
        }
    }

}
