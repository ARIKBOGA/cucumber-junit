package com.cydeo.step_definitions;

import com.cydeo.utulities.Driver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GoogleStepDefinitions {
    private WebDriver driver = Driver.getDriver();

    @When("user is on Google search page")
    public void userIsOnGoogleSearchPage() {
        driver.get("https://www.google.com");
        System.out.println("User is on google search page");
    }

    @Then("user should see title is Google")
    public void userShouldSeeTitleIsGoogle() {
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("User is seeing title is Google");

        Driver.closeDriver();
    }
}