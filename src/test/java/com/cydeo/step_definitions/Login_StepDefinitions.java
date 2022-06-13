package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @When("I enter valid {string} and {string}")
    public void iEnterValidAnd(String username, String password) {
    }


    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
    }

    @Then("I should be logged in to {string} account")
    public void iShouldBeLoggedInToAccount(String accountType) {
    }


    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, "Invalid username or password.");
    }
}