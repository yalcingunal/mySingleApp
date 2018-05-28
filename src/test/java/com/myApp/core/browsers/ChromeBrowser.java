package com.myApp.core.browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class ChromeBrowser extends BrowserBase {

    public ChromeBrowser() {
        super(DesiredCapabilities.chrome(), "chromedriver");
    }

    @Override
    void configure(DesiredCapabilities caps, Platform platform, File driverFile) {
        System.setProperty("webdriver.chrome.driver", driverFile.getPath());

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("process-per-site");
        chromeOptions.addArguments("--dns-prefetch-disable");


        if (platform == Platform.LINUX) {
            chromeOptions.addArguments("headless");
        }

        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    }

    @Override
    RemoteWebDriver create(DesiredCapabilities caps) {
        return new ChromeDriver(caps);
    }
}
