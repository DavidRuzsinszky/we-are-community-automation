package org.example.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    @FindBy(xpath = "//div/input[@class='evnt-text-fields form-control evnt-search small']")
    private WebElement searchBar;

    @FindBy(xpath = "//div/span[@class='evnt-search-icon']")
    private WebElement searchButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieDisclaimerButton;

    @FindBy(css = "a[href*='/all-events']")
    private WebElement articlesPageButton;

    @FindBy(xpath = "//li[@class='evnt-tools-menu language nav-item dropdown']/a")
    private WebElement languageSelector;

    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right show']/a[2]")
    private WebElement option;

    @FindBy(xpath = "//a[@href='/login?return_url=%2F']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class = 'evnt-text']/h1")
    private WebElement header;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFieldFilledWithValue(String value) {
        waitForElementToBeClickable(searchBar);
        searchBar.click();
        searchBar.sendKeys(value);
    }

    public void clickOnTheSearchButton() {
        waitForElementToBeClickable(searchButton);
        searchButton.click();
    }

    public void clickOnTheAriclesButton() {
        waitForElementToBeClickable(articlesPageButton);
        articlesPageButton.click();
    }

    public void clickOnTheLanguageSelector() {
        waitForElementToBeClickable(languageSelector);
        languageSelector.click();
    }

    public void clickOnTheRussianOption() {
        waitForElementToBeClickable(option);
        option.click();
    }

    public void clickOnTheLoginButton() throws InterruptedException {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
        Thread.sleep(5000);
    }

    public void checkWelcomeHeader() {
        String actual = header.getText();
        String expected = "Achieve more with the community";
        Assert.assertEquals(expected, actual);
    }

    public void clickOnTheCookieDisclaimer() {
        waitForElementToBeClickable(cookieDisclaimerButton);
        cookieDisclaimerButton.click();
    }

    public void waitForElementToBeClickable(final WebElement webElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.elementToBeClickable(webElement)
            );
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("Element is not clickable!");
        }
    }
}
