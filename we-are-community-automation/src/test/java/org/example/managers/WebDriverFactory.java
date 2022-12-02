package org.example.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.dataProvider.FileReaderManager;
import org.example.enums.DriverType;
import org.example.enums.EnvironmentType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WebDriverFactory {
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        EnvironmentType environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        DriverType driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        switch (driverType) {
            case FIREFOX:
                driver = setUpFirefoxDriver();
                break;
            case CHROME:
                driver = setUpChromeDriver();
                break;
            case INTERNETEXPLORER:
                driver = new InternetExplorerDriver();
                break;
        }
        return driver;
    }

    private WebDriver setUpFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public void close() {
        if (Objects.nonNull(driver)) {
            driver.close();
            driver = null;
        }
    }

}
