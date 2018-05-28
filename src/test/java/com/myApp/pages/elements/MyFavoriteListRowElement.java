package com.myApp.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyFavoriteListRowElement extends RowElement<RowElement>{
    @FindBy(css = "[class='productName ']")
    private WebElement productName;

    @FindBy(css = "[class='deleteProFromFavorites']")
    private WebElement removeButton;

    public String getProdcutName(){
        return productName.getText();
    }

    public void removeFavoriteProduct(){
        removeButton.click();
    }
}
