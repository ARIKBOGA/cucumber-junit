package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//select")
    public WebElement productDropdown;

    @FindBy(xpath = "(//div[@class='columns']//input)[1]")
    public WebElement quantityTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[2]")
    public WebElement pricePerUnitTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[3]")
    public WebElement discountTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[4]")
    public WebElement totalTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[5]")
    public WebElement customerNameTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[6]")
    public WebElement streetTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[7]")
    public WebElement cityTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[8]")
    public WebElement stateTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[9]")
    public WebElement zipcodeTextbox;

    /*
      @FindBy(xpath = "(//div[@class='columns']//input)[10]")
    public WebElement visaCheckbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[11]")
    public WebElement mastercardCheckbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[12]")
    public WebElement americanExpressCheckbox;
     */

    @FindBy(xpath ="//label[@class='radio']")
    public List<WebElement> creditCardsRadioButtons;

    @FindBy(xpath = "(//div[@class='columns']//input)[13]")
    public WebElement cardNoTextbox;

    @FindBy(xpath = "(//div[@class='columns']//input)[14]")
    public WebElement expiryDateTextbox;

    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculateButton;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderButton;

    @FindBy(xpath = "//button[.='Reset Fields']")
    public WebElement resetFieldsButton;

    @FindBy(xpath = "//tbody/tr//td[1]")
    public List<WebElement> ordersCustomerNamesList;

    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
