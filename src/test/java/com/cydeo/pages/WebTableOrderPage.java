package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class WebTableOrderPage {

    public WebTableOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
