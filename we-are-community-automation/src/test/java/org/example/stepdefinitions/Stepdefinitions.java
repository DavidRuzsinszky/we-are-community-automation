package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.TestConfig;
import org.example.dataProvider.ConfigFileReader;
import org.example.managers.PageObjectManager;
import org.example.managers.WebDriverFactory;
import org.example.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
public class Stepdefinitions {
    WebDriver driver;
    @Autowired
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

    @Given("the Main page is loaded")
    public void theMainPageIsOpened() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.waitForPageReadiness();
    }

    @When("the search field filled with {string}")
    public void theSearchFieldFilledWithValue(String value) {
        mainPage = pageObjectManager.getMainPage();
        mainPage.searchFieldFilledWithValue(value);
    }

    @And("the Search button is clicked")
    public void iClickOnTheSearchButton() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheSearchButton();
    }

    @Then("the {string} page loaded")
    public void theRequiredPageLoaded(String value) {
        searchPage = pageObjectManager.getSearchPage();
        searchPage.requiredPageLoaded(value);
    }

    @When("the Events button is clicked")
    public void iClickOnTheAriclesButton() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheAriclesButton();
    }

    @When("the Location is clicked")
    public void iClickOnTheLocation() {
        eventsPage = pageObjectManager.getEventsPage();
        eventsPage.clickOnTheLocationButton();

    }

    @And("the Location input is filled with {string}")
    public void iFillTheInputWithHungary(String location) {
        eventsPage = pageObjectManager.getEventsPage();
        eventsPage.fillTheLocationInput(location);
    }

    @And("{string} is selected from the list")
    public void iSelectValueFromTheList(String value) {
        eventsPage.selectValueFromTheList(value);
    }

    @When("the language selector is clicked")
    public void iClickOnTheLanguageSelector() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheLanguageSelector();
    }

    @And("russian option is selected")
    public void iClickOnTheRussianOption() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheRussianOption();
    }

    @When("the Login button is clicked")
    public void iClickOnTheLoginButton() {
        mainPage = pageObjectManager.getMainPage();
        mainPage.clickOnTheLoginButton();
    }

    @And("the Login page is opened")
    public void theLoginPageOpened() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.checkLoginPageWelcomeHeader();
    }

    @And("the email field is filled with {string}")
    public void iFillTheEmailField(String email) {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.fillTheEmailField(email);

    }

    @And("the Continue button is clicked")
    public void iClickOnTheContinueButton() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.clickOnTheLoginButton();
    }

    @And("the {string} is filled with {string}")
    public void iFillThePasswordFieldWithInvalidValue(final String field, final String content) {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.getInputFieldByName(field).sendKeys(content);
    }

    @Then("^the '(.*)' error message of the '(?:.*)' (?:field) should be shown$")
    public void theLengthErrorValueIsTheRequired(String errorMsg) {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.lenghtErrorIsTheExpected(errorMsg);
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

    @And("the user credentials are filled with the followings")
    public void iFillTheUserCredentialsWithTheFollowings(DataTable userCredentials) {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.fillLoginCredentials(userCredentials);
    }

    @And("the header value is {string}")
    public void theHeaderValueIs(String header) {
        mainPage = pageObjectManager.getMainPage();
        mainPage.theHeaderIsTheExpected(header);
    }
}
