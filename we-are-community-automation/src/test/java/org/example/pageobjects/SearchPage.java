package org.example.pageobjects;

import org.example.managers.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class SearchPage extends PageObjectUtils {
    @FindBy(xpath = "//div/h1")
    private WebElement logo;
    @FindBy(xpath = "//h2[text()='Debrecen Java Community']")
    private WebElement card;

    public SearchPage(WebDriverFactory factory) {
        super(factory);
    }

    public void requiredPageLoaded(String value) {
        String actual = logo.getText();
        Assert.assertEquals(value, actual.toLowerCase());
    }
}
