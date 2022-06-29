package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {

    @FindBy(id = "prependedInput")
    private WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInput;

    @FindBy(id = "_submit")
    private WebElement submitButton;

    @FindBy(id = "remember_me")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//*[text() = 'Forgot your password?']")
    private WebElement forgotPasswordLink;

    public VyTrackLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public  void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
