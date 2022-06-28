package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    public static void main(String[] args) {

        String path = "Sample_excel.xlsx";
        FileInputStream fis;
        XSSFWorkbook workbook;
        XSSFSheet sheet = null;

        try {

            fis = new FileInputStream(path);

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet("Employees");

        } catch (IOException e) {
            e.printStackTrace();
        }


        // TODO: Print the Job title of "Vinod"

        // method: getPhysicalNumberOfRows() returns the number of used rows. It doesn't care empty rows
        assert sheet != null;
        int usedRows = sheet.getPhysicalNumberOfRows();

        String person = "Vinod";

        for (int i = 0; i < usedRows; i++) {
            if (sheet.getRow(i).getCell(0).toString().equals("Vinod")) {
                System.out.println("\"" + person + "\"s job title is: " + sheet.getRow(i).getCell(2));
                break;
            }
        }
    }
}