package org.example.pageobjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

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

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFieldFilledWithValue(String value) {
        searchBar.click();
        searchBar.sendKeys(value);
    }

    public void clickOnTheSearchButton() {
        searchButton.click();
    }

    public void clickOnTheAriclesButton() {
        articlesPageButton.click();
    }

    public void clickOnTheLanguageSelector() {
        languageSelector.click();
    }

    public void clickOnTheRussianOption() {
        option.click();
    }

    public void clickOnTheLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(5000);
    }
}
