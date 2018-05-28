package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import com.myApp.pages.elements.MyFavoriteListRowElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyFavoritePage extends MyAccountPage {

    @FindBy(css = "[class='listView']")
    List<MyFavoriteListRowElement> myFavoriteListRowElements;

    @FindBy(css = "[class='message']")
    private WebElement messageTextField;

    @FindBy(css = "[class='btn btnBlack confirm']")
    private WebElement confirmButton;

    public MyFavoritePage(MyWebDriver driver) {
        super(driver);
    }

    public String getFavoriteProductNameWithIndex(int index) {
        return myFavoriteListRowElements.get(index - 1).getProdcutName();
    }

    public void removeFavoriteProductWithIndex(int index) {
        myFavoriteListRowElements.get(index - 1).removeFavoriteProduct();
    }

    public String getMessage() {
        return waitUntilVisibleWebElement(messageTextField).getText();
    }

    public void confirmMessage() {
        waitUntilClickable(waitUntilBeingWebElement(confirmButton, System.currentTimeMillis())).click();
    }

    public int sizeOfFavoriteProduct() {
        return myFavoriteListRowElements.size();
    }
}
