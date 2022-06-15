package com.cydeo.pages;

import com.cydeo.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {

    @FindBy(id = "searchInput")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(id = "firstHeading")
    public WebElement mainHeader;

    public WikiSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}