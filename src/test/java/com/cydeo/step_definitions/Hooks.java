package com.cydeo.step_definitions;

import com.cydeo.utulities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
    @Before
    public void setUp() {
        Driver.getDriver();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    @BeforeStep
    public void beforeStep() {}

    @AfterStep
    public void takesScreenshot() {}
}
