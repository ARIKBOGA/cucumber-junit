package com.cydeo.utilities;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BrowserUtils {

    /**
     * This method will wait throughout the given time.
     *
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
     *
     * @param element : element to wait for visibility of it
     */
    public static void waitForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
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

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    /**
     * This method accepts a String "expectedTitle" and Asserts if it is true
     *
     * @param expectedTitle: expected title to be compared against actualTitle
     */
    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }


    /**
     * Creating a utility method for ExplicitWait, so we don't have to repeat the lines
     *
     * @param webElement : This method will accept a WebElement
     */
    public static void waitForInvisibilityOf(WebElement webElement) {
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }


    /**
     * This method will accept a String "expectedText" and Asserts if it is true
     *
     * @param expectedInUrl : This method will accept a String "expectedText"
     */
    public static void verifyURLContains(String expectedInUrl) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }


    /**
     * This method returns a list of strings of given dropdown element's options
     * @param dropdown : This method will accept a WebElement which can be assumed to be a dropdown
     * @return : List<String> of dropdown element's options
     */
    public static List<String> dropdownOptionsAsStringList(WebElement dropdown) {
        Select select = new Select(dropdown);
        return select.getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    /**
     * This method will accept a WebElement which can be used to a Select and selects the given option
     * @param dropdown : This method will accept a WebElement which can be assumed to be a dropdown
     * @param option : This method will accept a String "option"
     */
    public static void selectAnOptionFromDropdown(WebElement dropdown, String option) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    /**
     * This method will accept a WebElement which can be used to a Select
     * @param productDropdown: This method will accept a WebElement which can be assumed to be a dropdown
     * @return This method will return the first selected option given element
     */
    public static WebElement getFirstSelectedOption(WebElement productDropdown) {
        Select select = new Select(productDropdown);
        return select.getFirstSelectedOption();
    }


    /**
     * This method selects the given value from a list of RadioButtons
     * It compares text of the radio button with the given value
     * @param radioButtons : List of RadioButtons
     * @param value: String value of will be selected radio button
     */
    public static void selectFromRadioButtons(@NotNull List<WebElement> radioButtons, String value) {
        radioButtons.stream()
                .filter(each -> each.getText().equalsIgnoreCase(value))
                .findFirst()
                .ifPresent(WebElement::click);
    }
}