package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewAllOrdersPage extends BasePage {

    @FindBy(xpath = "//tbody/tr//td[1]")
    public List<WebElement> ordersCustomerNamesList;

    public ViewAllOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
