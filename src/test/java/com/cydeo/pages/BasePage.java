package com.cydeo.pages;


import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * In this class we will store WebElements common to all pages
 */
public class BasePage {

    @FindBy(xpath = "//button[.='View all orders']")
    public WebElement viewAllOrdersButton;

    @FindBy(xpath = "//button[.='View all products']")
    public WebElement viewAllProductsButton;

    @FindBy(xpath = "//button[.='Order']")
    public WebElement orderButton;

    @FindBy(xpath = "//button[.='Logout']")
    public WebElement logoutButton;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
