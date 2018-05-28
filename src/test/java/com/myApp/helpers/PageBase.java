package com.myApp.helpers;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import com.myApp.core.driver.MyWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected MyWebDriver driver;
    private WebDriverWait wait;

    protected PageBase(MyWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement waitUntilVisibleWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public WebElement scrollToElement(WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public WebElement waitUntilBeingWebElement(WebElement element, long startTime) {
        if ((System.currentTimeMillis() - startTime) > 10000)
            return null;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element;
        } catch (StaleElementReferenceException e) {
            System.out.println(e);
            return waitUntilBeingWebElement(element, startTime);
        }

    }

    public void mauseOver(WebElement we) {
        Actions action = new Actions(driver);
        action.moveToElement(we).perform();
    }

}
