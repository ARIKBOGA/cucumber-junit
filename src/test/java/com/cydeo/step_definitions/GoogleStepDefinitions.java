package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleStepDefinitions {

    //private static final WebDriver DRIVER = Driver.getDriver();
    private  GoogleSearchPage GOOGLE_SEARCH_PAGE = new GoogleSearchPage();

    @When("user is on Google search page")
    public void userIsOnGoogleSearchPage() {
        Driver.getDriver().get("https://www.google.com");
        System.out.println("User is on google search page");
    }

    @Then("user should see title is Google")
    public void userShouldSeeTitleIsGoogle() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "Google");
        System.out.println("User is seeing title is Google");
    }

    @When("user types {word} and clicks enter")
    public void userTypesAndClicksEnter(String searchValue) {
        GOOGLE_SEARCH_PAGE.searchBox.sendKeys(searchValue + Keys.ENTER);
        System.out.println("User is typing and clicking enter");
    }

    @Then("user sees {string} in the google title")
    public void userSeesInTheGoggleTitle(String searchValue) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(searchValue));

        Assert.assertEquals(searchValue + " - Google'da Ara", Driver.getDriver().getTitle());

        if (Driver.getDriver().getTitle().contains(searchValue)) {
            System.out.println("User is seeing " + searchValue + " in the google title");
        } else {
            System.out.println("User is not seeing " + searchValue + " in the google title");
        }
    }
}