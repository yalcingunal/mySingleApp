package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePageBase {

    @FindBy(id = "email")
    private WebElement emailTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public LoginPage(MyWebDriver driver) {
        super(driver);
    }

    public void loginWithEmailAndPassword(String email, String password) {
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }
}
