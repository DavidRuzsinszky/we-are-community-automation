package org.example.config;

import org.example.managers.WebDriverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class TestConfig {
    @Bean(destroyMethod = "close")
    public WebDriverFactory webDriverFactory() {
        return new WebDriverFactory();
    }
}
