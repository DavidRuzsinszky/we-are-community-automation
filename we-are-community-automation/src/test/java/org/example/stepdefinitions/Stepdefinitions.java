package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public static final String HOME_PAGE_URL = "https://wearecommunity.io";


    @Given("the main page is loaded")
    public void theMainPageIsOpened() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
    }

    @When("the search field filled with {string}")
    public void theSearchFieldFilledWithValue(String value) {
        mainPage = new MainPage(driver);
        mainPage.searchFieldFilledWithValue(value);
    }

    @And("I click on the search button")
    public void iClickOnTheSearchButton() {
        mainPage.clickOnTheSearchButton();
    }

    @Then("the {string} page loaded")
    public void theRequiredPageLoaded(String value) {
        searchPage = new SearchPage(driver);
        searchPage.requiredPageLoaded(value);
    }

    @When("I click on the Events button")
    public void iClickOnTheAriclesButton() {
        mainPage = new MainPage(driver);
        mainPage.clickOnTheAriclesButton();
    }

    @When("I click on the Location")
    public void iClickOnTheLocation() {
        eventsPage = new EventsPage(driver);
        eventsPage.clickOnTheLocationButton();

    }

    @And("I fill the Location input with {string}")
    public void iFillTheInputWithHungary(String location) {
        eventsPage = new EventsPage(driver);
        eventsPage.fillTheLocationInput(location);
    }

    @And("I select {string} from the list")
    public void iSelectValueFromTheList(String value) {
        eventsPage.selectValueFromTheList(value);
    }

    @When("I click on the language selector")
    public void iClickOnTheLanguageSelector() {
        mainPage = new MainPage(driver);
        mainPage.clickOnTheLanguageSelector();
    }

    @And("I click on the russian option")
    public void iClickOnTheRussianOption() {
        mainPage.clickOnTheRussianOption();
    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.clickOnTheLoginButton();
    }

    @And("the Login page opened")
    public void theLoginPageOpened() {
        loginPage = new LoginPage(driver);
        loginPage.checkWelcomeHeader();
    }

    @And("I fill the email field")
    public void iFillTheEmailField() {
        loginPage.fillTheEmailField();

    }

    @And("I click on the Continue button")
    public void iClickOnTheContinueButton() throws InterruptedException {
        loginPage.clickOnTheLoginButton();
    }

    @And("I fill the password field with invalid value")
    public void iFillThePasswordFieldWithInvalidValue() throws InterruptedException {
        loginPage.fillLoginCredentials();
    }

    @Then("the error should be shown")
    public void theErrorShouldBeShown() {
        loginPage.lenghtErrorIsVisible();
    }
}
