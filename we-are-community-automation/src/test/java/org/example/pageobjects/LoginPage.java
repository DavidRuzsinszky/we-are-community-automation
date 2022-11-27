package org.example.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "chooseContainer")
    private WebElement welcomeHeader;

    @FindBy(id =  "username")
    private WebElement emailField;

    @FindBy(id =  "kc-login-next")
    private WebElement loginButton;

    @FindBy(id =  "firstName")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;
    @FindBy(id =  "hasLength-msg")
    private WebElement lenghtError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkWelcomeHeader(){
        String actual = welcomeHeader.getText();
        String expected = "Choose login option to proceed:";
        Assert.assertEquals(expected, actual);
    }

    public void fillTheEmailField(){
        emailField.sendKeys("Test@email.com");
    }

    public void clickOnTheLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(5000);
    }

    public void fillLoginCredentials() throws InterruptedException {
        firstName.sendKeys("Test");
        lastName.sendKeys("User");
        password.sendKeys("test");
        Thread.sleep(2000);
    }

    public void lenghtErrorIsVisible(){
        String actual = lenghtError.getText();
        String expected = "at least 9 characters";
        Assert.assertEquals(expected, actual);
    }

}
