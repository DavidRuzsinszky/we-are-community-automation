package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EventsPage {
    @FindBy(how = How.ID, using = "filter_location")
    private WebElement locationButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"agenda_filters\"]/div/div/div[1]/div/div/div[3]/div/div[2]/div[1]/input")
    private WebElement locationInputField;

    @FindBy(how = How.XPATH, using = "//div/label[@for=\"filter_location_0\"]")
    private WebElement locationCheckBox;

    public EventsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnTheLocationButton() {
        locationButton.click();
    }

    public void fillTheLocationInput(String location){
        locationInputField.sendKeys(location);
    }

    public void selectValueFromTheList(String value) {
        locationCheckBox.click();
    }
}
