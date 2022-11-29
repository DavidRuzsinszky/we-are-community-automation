package org.example.pageobjects;

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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkWelcomeHeader() {
        waitForPageReadiness();
        String actual = welcomeHeader.getText();
        String expected = "Choose login option to proceed:";
        Assert.assertEquals(expected, actual);
    }

    public void fillTheEmailField() {
        emailField.sendKeys("Test@email.com");
    }

    public void clickOnTheLoginButton() {
        loginButton.click();
    }

    public void fillLoginCredentials() {
        waitForElementToBeClickable(firstName);
        firstName.sendKeys("Test");
        lastName.sendKeys("User");
        password.sendKeys("test");
    }

    public void lenghtErrorIsVisible() {
        String actual = lenghtError.getText();
        String expected = "at least 9 characters";
        Assert.assertEquals(expected, actual);
    }

    public void waitForPageReadiness() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver ->
                        String.valueOf(
                                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
                        )
        );
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
