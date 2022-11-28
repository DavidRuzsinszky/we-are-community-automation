package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.dataProvider.ConfigFileReader;
import org.example.managers.PageObjectManager;
import org.example.managers.WebDriverManager;
import org.example.pageobjects.EventsPage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.MainPage;
import org.example.pageobjects.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stepdefinitions {
    WebDriver driver;
    MainPage mainPage;
    SearchPage searchPage;
    EventsPage eventsPage;
    LoginPage loginPage;

    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;
    ConfigFileReader configFileReader;


    @Given("the main page is loaded")
    public void theMainPageIsOpened() {
        webDriverManager = new WebDriverManager();
        configFileReader = new ConfigFileReader();
        driver = webDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(configFileReader.getApplicationUrl());
        pageObjectManager = new PageObjectManager(driver);
    }

    @When("the search field filled with {string}")
    public void theSearchFieldFilledWithValue(String value) {
        mainPage = pageObjectManager.getMainPage();
        mainPage.searchFieldFilledWithValue(value);
    }

    @And("I click on the search button")
    public void iClickOnTheSearchButton() {

        mainPage = pageObjectManager.getMainPage();mainPage.clickOnTheSearchButton();
    }

    @Then("the {string} page loaded")
    public void theRequiredPageLoaded(String value) {
        searchPage = pageObjectManager.getSearchPage();
        searchPage.requiredPageLoaded(value);
    }

    @When("I click on the Events button")
    public void iClickOnTheAriclesButton() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheAriclesButton();
    }

    @When("I click on the Location")
    public void iClickOnTheLocation() {
        eventsPage = pageObjectManager.getEventsPage();
        eventsPage.clickOnTheLocationButton();

    }

    @And("I fill the Location input with {string}")
    public void iFillTheInputWithHungary(String location) {
        eventsPage = pageObjectManager.getEventsPage();
        eventsPage.fillTheLocationInput(location);
    }

    @And("I select {string} from the list")
    public void iSelectValueFromTheList(String value) {
        eventsPage.selectValueFromTheList(value);
    }

    @When("I click on the language selector")
    public void iClickOnTheLanguageSelector() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheLanguageSelector();
    }

    @And("I click on the russian option")
    public void iClickOnTheRussianOption() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheRussianOption();
    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() throws InterruptedException {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheLoginButton();
    }

    @And("the Login page opened")
    public void theLoginPageOpened() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.checkWelcomeHeader();
    }

    @And("I fill the email field")
    public void iFillTheEmailField() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.fillTheEmailField();

    }

    @And("I click on the Continue button")
    public void iClickOnTheContinueButton() throws InterruptedException {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.clickOnTheLoginButton();
    }

    @And("I fill the password field with invalid value")
    public void iFillThePasswordFieldWithInvalidValue() throws InterruptedException {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.fillLoginCredentials();
    }

    @Then("the error should be shown")
    public void theErrorShouldBeShown() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.lenghtErrorIsVisible();
    }
    @After
    public void afterScenario(){
        webDriverManager.closeDriver();
    }
}
