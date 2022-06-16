package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserUtils {

    private static WebDriver driver = Driver.getDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, 5);


    /**
     * This method will wait throughout the given time.
     * @param second : time in seconds to wait explicitly
     */
    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException ignored) {

        }
    }


    /**
     * This method will wait until the given element is visible.
     * @param element : element to wait for visibility of it
     */
    public static void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * This method looks for if the given URL and Title are present in the browser's tabs.
     *
     * @param expectedInUrl    : expected URL , for verify if the url contains given String.
     *                         - If condition matches, will break loop.
     * @param expectedInTitle: expected Title, expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    /**
     * This method accepts a String "expectedTitle" and Asserts if it is true
     *
     * @param expectedTitle: expected title to be compared against actualTitle
     */
    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }


    /**
     * Creating a utility method for ExplicitWait, so we don't have to repeat the lines
     *
     * @param webElement : This method will accept a WebElement
     */
    public static void waitForInvisibilityOf(WebElement webElement) {
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }


    /**
     * This method will accept a String "expectedText" and Asserts if it is true
     *
     * @param expectedInUrl : This method will accept a String "expectedText"
     */
    public static void verifyURLContains(String expectedInUrl) {
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInUrl));
    }
}