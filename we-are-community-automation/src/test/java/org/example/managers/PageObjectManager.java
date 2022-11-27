package org.example.managers;

import org.example.pageobjects.EventsPage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.MainPage;
import org.example.pageobjects.SearchPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private EventsPage eventsPage;
    private LoginPage loginPage;

    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }

    public MainPage getMainPage() {
        return (mainPage == null) ? mainPage = new MainPage(driver) : mainPage;
    }

    public SearchPage getSearchPage() {
        return (searchPage == null) ? searchPage = new SearchPage(driver) : searchPage;
    }

    public EventsPage getEventsPage() {
        return (eventsPage == null) ? eventsPage = new EventsPage(driver) : eventsPage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }
}
