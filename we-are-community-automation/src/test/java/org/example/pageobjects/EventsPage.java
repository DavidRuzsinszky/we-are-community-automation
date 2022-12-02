package org.example.pageobjects;

import org.example.managers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class EventsPage extends PageObjectUtils {
    @FindBy(id = "filter_location")
    private WebElement locationButton;

    @FindBy(xpath = "//*[@id=\"agenda_filters\"]/div/div/div[1]/div/div/div[3]/div/div[2]/div[1]/input")
    private WebElement locationInputField;

    @FindBy(xpath = "//div/label[@for=\"filter_location_0\"]")
    private WebElement locationCheckBox;

    public EventsPage(WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnTheLocationButton() {
        locationButton.click();
    }

    public void fillTheLocationInput(String location) {
        locationInputField.sendKeys(location);
    }

    public void selectValueFromTheList() {
        locationCheckBox.click();
    }
}
