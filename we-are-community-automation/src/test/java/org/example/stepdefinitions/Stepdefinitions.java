package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.TestConfig;
import org.example.pageobjects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
public class Stepdefinitions {
    @Autowired
    MainPage mainPage;
    @Autowired
    SearchPage searchPage;
    @Autowired
    EventsPage eventsPage;
    @Autowired
    LoginPage loginPage;

    @Given("the Main page is loaded")
    public void theMainPageIsOpened() {
        mainPage.checkMainPageIsLoaded();
    }

    @When("the search field filled with {string}")
    public void theSearchFieldFilledWithValue(String value) {
        mainPage.searchFieldFilledWithValue(value);
    }

    @And("the Search button is clicked")
    public void iClickOnTheSearchButton() {
        mainPage.clickOnTheSearchButton();
    }

    @Then("the {string} page loaded")
    public void theRequiredPageLoaded(String value) {
        searchPage.requiredPageLoaded(value);
    }

    @When("the Events button is clicked")
    public void iClickOnTheAriclesButton() {
        mainPage.clickOnTheAriclesButton();
    }

    @When("the Location is clicked")
    public void iClickOnTheLocation() {
        eventsPage.clickOnTheLocationButton();

    }

    @And("the Location input is filled with {string}")
    public void iFillTheInputWithHungary(String location) {
        eventsPage.fillTheLocationInput(location);
    }

    @And("{string} is selected from the list")
    public void iSelectValueFromTheList(String value) {
        eventsPage.selectValueFromTheList();
    }

    @When("the language selector is clicked")
    public void iClickOnTheLanguageSelector() {
        mainPage.clickOnTheLanguageSelector();
    }

    @And("russian option is selected")
    public void iClickOnTheRussianOption() {
        mainPage.clickOnTheRussianOption();
    }

    @When("the Login button is clicked")
    public void iClickOnTheLoginButton() {
        mainPage.clickOnTheLoginButton();
    }

    @And("the Login page is opened")
    public void theLoginPageOpened() {
        loginPage.checkLoginPageWelcomeHeader();
    }

    @And("the email field is filled with {string}")
    public void iFillTheEmailField(String email) {
        loginPage.fillTheEmailField(email);

    }

    @And("the Continue button is clicked")
    public void iClickOnTheContinueButton() {
        loginPage.clickOnTheLoginButton();
    }

    @And("the {string} is filled with {string}")
    public void iFillThePasswordFieldWithInvalidValue(final String field, final String content) {
        loginPage.getInputFieldByName(field).sendKeys(content);
    }

    @Then("^the '(.*)' error message of the '(?:.*)' (?:field) should be shown$")
    public void theLengthErrorValueIsTheRequired(String errorMsg) {
        loginPage.lenghtErrorIsTheExpected(errorMsg);
    }

    @And("the Cookie disclaimer is closed")
    public void theCookieDisclaimerIsClosed() {
        mainPage.clickOnTheCookieDisclaimer();
    }

    @Then("the error message about invalid length is visible")
    public void theErrorAboutInvalidLengthIsVisible() {
        loginPage.lengthErrorIsVisible();
    }

    @And("the user credentials are filled with the followings")
    public void iFillTheUserCredentialsWithTheFollowings(DataTable userCredentials) {
        loginPage.fillLoginCredentials(userCredentials);
    }

    @And("the page header should be {string}")
    public void thePageHeaderIs(String header) {
        mainPage.checkThePageHeader(header);
    }
}
