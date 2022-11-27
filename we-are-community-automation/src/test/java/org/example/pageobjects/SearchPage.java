package org.example.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class SearchPage {
    WebDriver driver;
    @FindBy(xpath = "//div/h1")
    private WebElement logo;
    @FindBy(xpath = "//h2[text()='Debrecen Java Community']")
    private WebElement card;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void requiredPageLoaded(String value) {
        String actual = logo.getText();
        Assert.assertEquals(value, actual.toLowerCase());
    }
}
