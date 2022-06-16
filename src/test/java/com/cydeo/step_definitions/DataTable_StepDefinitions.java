package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;

import java.util.List;

public class DataTable_StepDefinitions {

    DropdownsPage dropdownsPage = new DropdownsPage();

    @Then("User should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println(fruits);
        System.out.println(fruits.get(1));
    }

    @Given("User is on the dropdowns page of practice tool")
    public void userIsOnTheDropdownsPageOfPracticeTool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @When("User should see below info in month dropdown menu")
    public void userShouldSeeBelowInfoInMonthDropdownMenu(@NotNull List<String> expectedMonths) {
        List<String> actualMonths = BrowserUtils.dropdownOptionsAsStringList(dropdownsPage.monthDropdown);
        Assert.assertTrue(actualMonths.containsAll(expectedMonths));
    }

}