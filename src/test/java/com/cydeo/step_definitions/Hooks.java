package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import com.google.common.io.Files;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public void setUp() {
       // Driver.getDriver();
    }

    @After
    public void teardownScenario(Scenario scenario) throws IOException {

        // Take a screenshot if the scenario fails
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            File screenshotFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            Files.move(screenshotFile, new File("src/test/resources/screenshots/" + scenario.getName() + ".png"));
        }
        Driver.closeDriver();
    }

    @BeforeStep
    public void beforeStep() {
    }

    @AfterStep
    public void takesScreenshot() {
    }
}