package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.pages.WebTableOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    WebTableOrderPage webTableOrderPage = new WebTableOrderPage();

    @Given("user is already logged in and on order page")
    public void userIsAlreadyLoggedInAndOnOrderPage() {
        webTableLoginPage.login();
    }

    @When("user selects product type {string}")
    public void userSelectsProductType(String productType) {
    }


    @And("user enters quantity {int}")
    public void userEntersQuantity(int quantity) {

    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String customerName) {

    }

    @And("user enters street {string}")
    public void userEntersStreet(String street) {

    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {

    }

    @And("user enters state {string}")
    public void userEntersState(String state) {

    }

    @And("user enters zipcode {string}")
    public void userEntersZipcode(String zipcode) {

    }

    @And("user selects credit card type {string}")
    public void userSelectsCreditCardType(String creditCardType) {

    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String creditCardNumber) {

    }

    @And("user enters expiry date {string}")
    public void userEntersExpiryDate(String expiryDate) {

    }

    @And("user enters process order button")
    public void userEntersProcessOrderButton() {
    }

    @Then("user should see {string} in first row of the web table")
    public void userShouldSeeInFirstRowOfTheWebTable(String productType) {

    }
}
