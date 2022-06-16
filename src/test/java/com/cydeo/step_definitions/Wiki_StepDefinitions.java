package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Wiki_StepDefinitions {

    public WikiSearchPage wikiSearchPage = new WikiSearchPage();
    public WebDriver driver = Driver.getDriver();

    @Given("User is on the Wikipedia home page")
    public void userIsOnTheWikipediaHomePage() {
        driver.get("https://www.wikipedia.org/");
    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String searchValue) {
        wikiSearchPage.searchBox.sendKeys(searchValue);
    }

    @And("User clicks wiki search button")
    public void userClicksWikiSearchButton() {
        wikiSearchPage.searchButton.click();
    }

    @Then("User sees {string} in the wiki title")
    public void userSeesInTheWikiTitle(String searchValue) {
        Assert.assertTrue(driver.getTitle().contains(searchValue));
    }

    @Then("User sees {string} in the wiki header")
    public void userSeesInTheWikiHeader(String searchValue) {
        Assert.assertTrue(wikiSearchPage.mainHeader.isDisplayed());
        Assert.assertEquals(searchValue, wikiSearchPage.mainHeader.getText());
    }
}