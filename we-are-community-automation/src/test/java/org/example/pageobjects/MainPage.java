package org.example.pageobjects;

import org.example.dataProvider.ConfigFileReader;
import org.example.managers.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends PageObjectUtils {
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

    public MainPage(final WebDriverFactory factory) {
        super(factory);
    }
    public void navigateToHomePage() {
        configFileReader = new ConfigFileReader();
        navigateToUrl(configFileReader.getApplicationUrl());
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
        waitForElementToBeVisible(checkHeader(header));
    }
}
