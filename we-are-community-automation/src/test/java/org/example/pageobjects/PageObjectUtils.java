package org.example.pageobjects;

import org.example.managers.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectUtils {

    WebDriverFactory factory;

    public PageObjectUtils(WebDriverFactory factory){
        PageFactory.initElements(factory.getDriver(), this);
        this.factory = factory;
    }

    public WebDriver getWebDriverFromFactory() {
        return factory.getDriver();
    }

    protected void navigateToUrl(final String url) {
        getWebDriverFromFactory().manage().window().maximize();
        getWebDriverFromFactory().get(url);
        waitForPageReadiness();
    }

    public void waitForElementToBeClickable(final WebElement webElement) {
        try {
            new WebDriverWait(getWebDriverFromFactory(), Duration.ofSeconds(10)).until(
                    ExpectedConditions.elementToBeClickable(webElement)
            );
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("Element is not clickable!");
        }
    }

    public void waitForPageReadiness() {
        new WebDriverWait(getWebDriverFromFactory(), Duration.ofSeconds(10)).until(
                driver ->
                        String.valueOf(
                                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
                        )
        );
    }

    public void waitForElementToBeVisible(final WebElement webElement) {
        try {
            new WebDriverWait(getWebDriverFromFactory(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("Element is not visible!");
        }
    }

    public WebElement checkHeader(String value) {
        getWebDriverFromFactory().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getWebDriverFromFactory().findElement(By.xpath(String.format("//h1[text()=\"%s\"]", value)));
    }
}
