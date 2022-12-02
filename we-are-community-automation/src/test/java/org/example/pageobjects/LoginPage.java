package org.example.pageobjects;

import io.cucumber.datatable.DataTable;
import org.example.dataProvider.ConfigFileReader;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

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
    private static WebElement password;
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

    public void fillTheEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void clickOnTheLoginButton() {
        loginButton.click();
    }

    public void fillLoginCredentials(DataTable userCredentials) {
        waitForElementToBeClickable(firstName);
        for (Map<String, String> credential : userCredentials.asMaps(String.class, String.class)) {
            firstName.sendKeys(credential.get("firstName"));
            lastName.clear();
            lastName.sendKeys(credential.get("lastName"));
        }
    }

    public WebElement getInputFieldByName(String field) {
        final Map<String, WebElement> inputFieldsMap = Map.of("Password", password);
        return inputFieldsMap.get(field);
    }

    public void lenghtErrorIsTheExpected(String msg) {
        waitForPageReadiness();
        WebElement error = driver.findElement(By.xpath(String.format("//li[text()=\"%s\"]", msg)));
        waitForElementToBeVisible(error);
    }

    public void lengthErrorIsVisible() {
        waitForElementToBeVisible(lenghtError);
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
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("Element is not clickable!");
        }
    }

    public void waitForElementToBeVisible(final WebElement webElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("Element is not visible!");
        }
    }
}
