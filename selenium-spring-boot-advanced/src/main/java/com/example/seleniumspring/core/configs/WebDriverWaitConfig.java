package com.example.seleniumspring.core.configs;

import com.example.seleniumspring.core.annotations.LazyConfiguration;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.time.Duration;

@LazyConfiguration
public class WebDriverWaitConfig {
    Logger logger = LoggerFactory.getLogger(WebDriverWaitConfig.class);

    @Value("${default.timeout:30}")
    private int timeOut;

    @Bean
//    @Scope("prototype")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait getWebdriverWait(WebDriver driver) { // 'driver' Will Be Automatically Passed From 'getChrome()' By Spring.
        logger.info("Getting WebDriverWait.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(this.timeOut));
        wait.ignoring(NotFoundException.class);
        return wait;
    }
}
