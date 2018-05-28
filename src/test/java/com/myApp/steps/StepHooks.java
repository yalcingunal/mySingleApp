package com.myApp.steps;

import com.myApp.core.driver.MyWebDriver;
import com.myApp.core.managers.ScreenshotManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import java.io.IOException;

public class StepHooks {

    private MyWebDriver webDriver;

    public StepHooks(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            ScreenshotManager.saveFailScenarioScreenshot(webDriver, scenario);
        }
        webDriver.manage().deleteAllCookies();
    }
}
