package com.myApp.core.driver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MyWebDriver extends EventFiringWebDriver {

    public MyWebDriver() {
        super(DriverFactory.getDriver(true));
    }

}
