package org.example.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class SearchPage {

    @FindBy(how = How.XPATH, using = "//div/h1")
    private WebElement logo;
    @FindBy(how = How.XPATH, using = "//h2[text()='Debrecen Java Community']")
    private WebElement card;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void requiredPageLoaded(String value) {
        String actual = logo.getText();
        Assert.assertEquals(value, actual.toLowerCase());
    }
}
