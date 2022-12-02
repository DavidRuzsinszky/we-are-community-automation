package org.example.pageobjects;

import org.example.dataProvider.ConfigFileReader;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;
    ConfigFileReader configFileReader;
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
    private WebElement headerElement;

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

    public void clickOnTheLoginButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    public void checkMainPageIsLoaded() {
        waitForPageReadiness();
    }

    public void clickOnTheCookieDisclaimer() {
        waitForElementToBeClickable(cookieDisclaimerButton);
        cookieDisclaimerButton.click();
    }


    public void checkThePageHeader(String header) {
        waitForPageReadiness();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement value = driver.findElement(By.xpath(String.format("//h1[text()=\"%s\"]", header)));
        waitForElementToBeVisible(value);
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
    public void waitForPageReadiness() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver ->
                        String.valueOf(
                                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
                        )
        );
    }
    public void waitForElementToBeVisible(final WebElement webElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("Element is not visible!");
        }
    }
}
