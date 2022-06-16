package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownsPage {

    @FindBy(id = "month")
    public WebElement monthDropdown;

    public DropdownsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
