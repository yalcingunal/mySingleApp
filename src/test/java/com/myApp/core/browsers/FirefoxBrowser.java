package com.myApp.core.browsers;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class FirefoxBrowser extends BrowserBase {

    FirefoxBrowser() {
        super(DesiredCapabilities.firefox(), "geckodriver");
    }

    private void configureForLinux() {
        File homePath = new File(System.getenv("HOME") + File.separator);
        File mozillaPath = new File(homePath + File.separator + ".mozilla");
        File tmpFile;
        if (mozillaPath.exists()) {
            try {
                tmpFile = File.createTempFile("webdriver", null, mozillaPath);
            } catch (IOException ex) {
                throw new WebDriverException(
                        "Can't create file in path: %s".replace("%s", mozillaPath.getAbsolutePath()));
            }
        } else {
            try {
                tmpFile = File.createTempFile("webdriver", null, homePath);
            } catch (IOException ex) {
                throw new WebDriverException(
                        "Can't create file in path: %s".replace("%s", homePath.getAbsolutePath()));
            }
        }
        tmpFile.delete();
    }

    @Override
    void configure(DesiredCapabilities caps, Platform platform, File driverFile) {
        System.setProperty("webdriver.gecko.driver", driverFile.getPath());
        System.setProperty("webdriver.firefox.bin", driverFile.getPath());

        if (platform == Platform.LINUX) {
            configureForLinux();
        }
    }

    @Override
    RemoteWebDriver create(DesiredCapabilities caps) {
        return new FirefoxDriver(caps);
    }
}
