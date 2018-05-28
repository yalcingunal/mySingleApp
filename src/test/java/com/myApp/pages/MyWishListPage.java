package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListPage extends MyAccountPage {

    @FindBy(css = "[class='listItemTitle']")
    private WebElement myFavoriteButton;

    public MyWishListPage(MyWebDriver driver) {
        super(driver);
    }

    public void goToMyFavorite(){
        waitUntilVisibleWebElement(myFavoriteButton).click();
    }
}
