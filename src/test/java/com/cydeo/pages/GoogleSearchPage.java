package com.cydeo.pages;

import com.cydeo.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    @FindBy(name = "q")
    public WebElement searchBox;

    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
