package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.dataProvider.ConfigFileReader;
import org.example.managers.PageObjectManager;
import org.example.managers.WebDriverFactory;
import org.example.pageobjects.*;
import org.openqa.selenium.WebDriver;

public class Stepdefinitions {
    WebDriver driver;
    MainPage mainPage;
    SearchPage searchPage;
    EventsPage eventsPage;
    LoginPage loginPage;

    PageObjectManager pageObjectManager;
    WebDriverFactory webDriverFactory;
    ConfigFileReader configFileReader;

    @Before
    public void beforeScenario() {
        webDriverFactory = new WebDriverFactory();
        configFileReader = new ConfigFileReader();
        driver = webDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(configFileReader.getApplicationUrl());
        pageObjectManager = new PageObjectManager(driver);
    }

    @After
    public void afterScenario() {
        webDriverFactory.closeDriver();
    }

    @Given("the main page is loaded")
    public void theMainPageIsOpened() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.checkMainPageWelcomeHeader();
    }

    @When("the search field filled with {string}")
    public void theSearchFieldFilledWithValue(String value) {
        mainPage = pageObjectManager.getMainPage();
        mainPage.searchFieldFilledWithValue(value);
    }

    @And("I click on the search button")
    public void iClickOnTheSearchButton() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheSearchButton();
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
    public void iClickOnTheLoginButton() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheLoginButton();
    }

    @And("the Login page opened")
    public void theLoginPageOpened() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.checkLoginPageWelcomeHeader();
    }

    @And("I fill the email field")
    public void iFillTheEmailField() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.fillTheEmailField();

    }

    @And("I click on the Continue button")
    public void iClickOnTheContinueButton() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.clickOnTheLoginButton();
    }

    @And("I fill the password field with invalid value")
    public void iFillThePasswordFieldWithInvalidValue() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.fillLoginCredentials();
    }

    @Then("the length error's value is the required")
    public void theLengthErrorValueIsTheRequired() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.lenghtErrorIsTheExpected();
    }

    @And("the Cookie disclaimer is closed")
    public void theCookieDisclaimerIsClosed() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheCookieDisclaimer();
    }

    @Then("the error message about invalid length is visible")
    public void theErrorAboutInvalidLengthIsVisible() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.lengthErrorIsVisible();
    }
}
