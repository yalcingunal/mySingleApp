package com.myApp.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductRowElement extends RowElement<RowElement> {

    @FindBy(css = "[class='productName bold']")
    private WebElement productName;

    @FindBy(css = "[class='textImg followBtn']")
    private WebElement addFavoriteButton;

    public String getProductTitle() {
        return productName.getText();
    }

    public void addToFavorite() {
        addFavoriteButton.click();
    }
}
