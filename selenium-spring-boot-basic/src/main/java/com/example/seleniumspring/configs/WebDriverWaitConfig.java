package com.example.seleniumspring.configs;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.Duration;

@Lazy
@Configuration
public class WebDriverWaitConfig {
    Logger logger = LoggerFactory.getLogger(WebDriverWaitConfig.class);

    @Value("${default.timeout:30}")
    private int timeOut;

    @Lazy
    @Bean
    public WebDriverWait getWebdriverWait(WebDriver driver) { // 'driver' Will Be Automatically Passed From 'getChrome()' By Spring.
        logger.info("Getting WebDriverWait.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(this.timeOut));
        wait.ignoring(NotFoundException.class);
        return wait;
    }
}
