package com.cydeo.step_definitions;

import com.cydeo.utulities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.bouncycastle.util.test.SimpleTestResult;
import org.bouncycastle.util.test.TestResult;
import org.junit.Test;

public class Hooks {
    @Before
    public void setUp() {
        Driver.getDriver();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    @AfterStep
    public void takesScreenshot() {
    }
}
