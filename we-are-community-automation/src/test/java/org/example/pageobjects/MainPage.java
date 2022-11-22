package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//div/input[@class='evnt-text-fields form-control evnt-search small']")
    private WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//div/span[@class='evnt-search-icon']")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void searchFieldFilledWithValue(String value) {
        searchBar.click();
        searchBar.sendKeys(value);
    }

    public void clickOnTheSearchButton() {
        searchButton.click();
    }


}
