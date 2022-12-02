package org.example.hooks;

import io.cucumber.java.Before;
import org.example.pageobjects.MainPage;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
    @Autowired
    MainPage mainPage;

    @Before
    public void beforeScenario() {
        mainPage.navigateToHomePage();
    }

}
