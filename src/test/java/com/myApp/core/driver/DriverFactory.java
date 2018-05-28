package com.myApp.core.driver;

import com.myApp.core.configuration.AppSettings;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

class DriverFactory {

    private static RemoteWebDriver REAL_DRIVER = null;
    private static final Logger LOGGER = Logger.getLogger(DriverFactory.class);
    private static final Thread CLOSE_THREAD = new Thread(DriverFactory::close);

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    private static void newInstance() {
        try {
            close();
            REAL_DRIVER = AppSettings.Instance.Browser.getBrowserClass().newInstance().getDriver();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("Driver creation fail", e);
        }
    }

    static RemoteWebDriver getDriver(boolean newInstance) {
        if (newInstance || REAL_DRIVER == null) {
            LOGGER.info("Creating new driver instance...");
            newInstance();
        }
        return REAL_DRIVER;
    }

    private static void close() {
        if (REAL_DRIVER != null) {
            LOGGER.info("Closing driver instance...");
            REAL_DRIVER.quit();
            REAL_DRIVER = null;
        }
    }
}
