package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    private static final String path = "Sample_excel.xlsx";
    private static final String sheetName = "VyTrackQA2User";
    //private static final String expectedTitle = "Dashboard";

    private final VyTrackLoginPage loginPage = new VyTrackLoginPage();
    private final VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    private static final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Before
    public void getPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws IOException {

        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            String username = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstname = sheet.getRow(i).getCell(2).toString();
            String lastname = sheet.getRow(i).getCell(3).toString();
            loginPage.login(username, password);

            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));

            boolean r1 = dashboardPage.fullName.getText().equals(firstname + " " + lastname);
            Assert.assertTrue(r1);

            String result = r1 ? "PASSED" : "FAILED";
            sheet.getRow(i).createCell(4).setCellValue(result);

            dashboardPage.logout();
        }

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        fos.close();
        workbook.close();
        fis.close();
    }
}