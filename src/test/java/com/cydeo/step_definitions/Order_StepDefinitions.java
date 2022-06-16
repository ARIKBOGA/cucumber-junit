package com.cydeo.step_definitions;

import com.cydeo.pages.OrderPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    OrderPage orderPage = new OrderPage();

    @Given("user is already logged in and on order page")
    public void userIsAlreadyLoggedInAndOnOrderPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
        webTableLoginPage.login();
        orderPage.orderButton.click();
    }

    @When("user selects product type {string}")
    public void userSelectsProductType(String productType) {
        BrowserUtils.selectAnOptionFromDropdown(orderPage.productDropdown, productType);
        //System.out.println(BrowserUtils.getFirstSelectedOption(orderPage.productDropdown).getText());
    }


    @And("user enters quantity {string}")
    public void userEntersQuantity(String quantity) {
        orderPage.quantityTextbox.sendKeys(quantity);
    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String customerName) {
        orderPage.customerNameTextbox.sendKeys(customerName);
    }

    @And("user enters street {string}")
    public void userEntersStreet(String street) {
        orderPage.streetTextbox.sendKeys(street);
    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {
        orderPage.cityTextbox.sendKeys(city);
    }

    @And("user enters state {string}")
    public void userEntersState(String state) {
        orderPage.stateTextbox.sendKeys(state);
    }

    @And("user enters zipcode {string}")
    public void userEntersZipcode(String zipcode) {
        orderPage.zipcodeTextbox.sendKeys(zipcode);
    }

    @And("user selects credit card type {string}")
    public void userSelectsCreditCardType(String creditCardType) {
       BrowserUtils.selectFromRadioButtons(orderPage.creditCardsRadioButtons, creditCardType);
    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String creditCardNumber) {
        orderPage.cardNoTextbox.sendKeys(creditCardNumber);
    }

    @And("user enters expiry date {string}")
    public void userEntersExpiryDate(String expiryDate) {
        orderPage.expiryDateTextbox.sendKeys(expiryDate);
    }

    @And("user enters process order button")
    public void userEntersProcessOrderButton() {
        orderPage.processOrderButton.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void userShouldSeeInFirstRowOfTheWebTable(String productType) {
        String firstRow = orderPage.ordersCustomerNamesList.get(0).getText();
        Assert.assertEquals(productType, firstRow);
    }
}