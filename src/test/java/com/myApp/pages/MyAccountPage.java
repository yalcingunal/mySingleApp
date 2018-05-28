package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends HomePageBase {

    @FindBy(css = "[class='userName']")
    private WebElement userName;

    public MyAccountPage(MyWebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userName.getText();
    }
}
