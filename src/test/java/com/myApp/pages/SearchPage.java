package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import com.myApp.pages.elements.ProductRowElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchPage extends HomePageBase {
    @FindBy(css = "[class='resultText ']")
    private WebElement resultMessageText;

    @FindBy(css = "[class='pagination']")
    private WebElement pagination;

    @FindBy(css = "[class='pagination'] a")
    private List<WebElement> indexes;

    @FindBy(id = "currentPage")
    private WebElement currentPageIndex;

    @FindBy(css = "[class=\"column \"]")
    private List<ProductRowElement> productRowElements;


    public SearchPage(MyWebDriver driver) {
        super(driver);
    }

    public String getResultMessage() {
        return waitUntilBeingWebElement(resultMessageText, System.currentTimeMillis()).getText();
    }

    public String getActivePageIndex() {
        return currentPageIndex.getAttribute("value");
    }

    public String getProductNameWithIndex(int index) {
        return productRowElements.get(index).getProductTitle();
    }

    public String addToFavoriteWithIndex(int index) {
        productRowElements.get(index - 1).addToFavorite();
        return productRowElements.get(index - 1).getProductTitle();
    }

    public void goToSearchPageWithIndex(int index) {
        scrollToElement(pagination);
        indexes.get(index - 1).click();
    }
}
