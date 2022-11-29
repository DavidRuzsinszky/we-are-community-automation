package org.example.pageobjects;

import org.example.dataProvider.ConfigFileReader;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "chooseContainer")
    private WebElement welcomeHeader;

    @FindBy(id = "username")
    private WebElement emailField;

    @FindBy(id = "kc-login-next")
    private WebElement loginButton;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;
    @FindBy(id = "hasLength-msg")
    private WebElement lenghtError;

    @FindBy(id = "kc-form-wrapper")
    private WebElement form;

    ConfigFileReader configFileReader;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkLoginPageWelcomeHeader() {
        configFileReader = new ConfigFileReader();
        waitForElementToBeVisible(form);
        String actual = welcomeHeader.getText();
        String expected = configFileReader.getLoginPageWelcomeHeader();
        Assert.assertEquals(expected, actual);
    }

    public void fillTheEmailField() {
        configFileReader = new ConfigFileReader();
        emailField.sendKeys(configFileReader.getTestEmail());
    }

    public void clickOnTheLoginButton() {
        loginButton.click();
    }

    public void fillLoginCredentials() {
        configFileReader = new ConfigFileReader();
        waitForElementToBeClickable(firstName);
        firstName.sendKeys(configFileReader.getFirstName());
        lastName.sendKeys(configFileReader.getLastName());
        password.sendKeys(configFileReader.getPassword());
    }

    public void lenghtErrorIsTheExpected() {
        configFileReader = new ConfigFileReader();
        String actual = lenghtError.getText();
        String expected = configFileReader.getLengthError();
        Assert.assertEquals(expected, actual);
    }

    public void lengthErrorIsVisible() {
        waitForElementToBeVisible(lenghtError);
    }

//    public void waitForPageReadiness() {
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
//                driver ->
//                        String.valueOf(
//                                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
//                        )
//        );
//    }

    public void waitForElementToBeClickable(final WebElement webElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.elementToBeClickable(webElement)
            );
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("Element is not clickable!");
        }
    }

    public void waitForElementToBeVisible(final WebElement webElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.visibilityOf(webElement)
            );
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("Element is not visible!");
        }
    }
}
