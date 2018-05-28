package com.myApp.pages;

import com.myApp.core.configuration.AppSettings;
import com.myApp.core.driver.MyWebDriver;
import com.myApp.helpers.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class HomePageBase extends PageBase {

    @FindBy(css = "[class='btnSignIn']")
    private WebElement loginButton;

    @FindBy(css = "[class='menuLink user']")
    private WebElement nameAndSurname;

    @FindBy(id = "searchData")
    private WebElement searchTextBox;

    @FindBy(css = "[class='searchBtn']")
    private WebElement searchButton;

    @FindBy(css = "[title='İstek Listem / Favorilerim']")
    private WebElement myFavoriteButton;

    public HomePageBase(MyWebDriver driver) {
        super(driver);
    }

    public void navigate() throws InterruptedException {
        driver.get(String.join("/", AppSettings.Instance.BaseUrl));
    }

    public void navigate(String path) {
        driver.get(String.join("/", AppSettings.Instance.BaseUrl) + path);
    }

    public void pageRefresh() {
        driver.navigate().refresh();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void goToLoginPage() {
        loginButton.click();
    }

    public void searchWithValue(String value) {
        searchTextBox.clear();
        searchTextBox.sendKeys(value);
        searchButton.click();
    }

    public String getNameAndSurname() {
        return nameAndSurname.getText();
    }

    public void goToMyWishList() {
        mauseOver(nameAndSurname);
        waitUntilVisibleWebElement(myFavoriteButton).click();
    }
}
