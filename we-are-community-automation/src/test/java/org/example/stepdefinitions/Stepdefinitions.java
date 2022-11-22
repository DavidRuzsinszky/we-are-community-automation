package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobjects.MainPage;
import org.example.pageobjects.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stepdefinitions {
    WebDriver driver;
    MainPage mainPage;
    SearchPage searchPage;
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

    @Then("the required page loaded")
    public void theRequiredPageLoaded() {
        searchPage = new SearchPage(driver);
        searchPage.requiredPageLoaded();
    }
}
