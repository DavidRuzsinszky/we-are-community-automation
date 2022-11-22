package org.example.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(how = How.XPATH, using = "//h1[text()='Search']")
    private WebElement logo;
    @FindBy(how = How.XPATH, using = "//h2[text()='Debrecen Java Community']")
    private WebElement card;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void requiredPageLoaded() {
        String actual = logo.getText();
        Assert.assertEquals("SEARCH", actual);
        card.click();
    }
}
