package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void write_excel() throws IOException {
        String path = "Sample_excel.xlsx";
        String sheetName = "Employees";
        String newCellName = "Salary";

        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);


        int cellNumber = sheet.getRow(0).getPhysicalNumberOfCells();

        sheet.getRow(0).createCell(cellNumber).setCellValue(newCellName);
        sheet.getRow(1).createCell(cellNumber).setCellValue(200000);
        sheet.getRow(2).createCell(cellNumber).setCellValue(190000);
        sheet.getRow(3).createCell(cellNumber).setCellValue(175000);
        sheet.getRow(4).createCell(cellNumber).setCellValue(210000);





        FileOutputStream fos = new FileOutputStream(path);

        workbook.write(fos);


        fos.close();
        workbook.close();
        fis.close();

    }
}