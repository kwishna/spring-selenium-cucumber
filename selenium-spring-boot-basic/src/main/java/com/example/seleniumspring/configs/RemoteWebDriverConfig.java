package com.example.seleniumspring.configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.URL;
import java.time.Duration;

@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverConfig {

    Logger logger = LoggerFactory.getLogger(RemoteWebDriverConfig.class);

    @Value("${selenium.grid.url}")
    private URL GRID_URL;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver getFirefoxDriver() {
        logger.info("Creating Firefox Remote Driver.");
        WebDriverManager.firefoxdriver().setup();
        return new RemoteWebDriver(this.GRID_URL, new FirefoxOptions() {{
            setHeadless(false);
            addArguments("--start-maximized");
            setAcceptInsecureCerts(true);
            setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        }});
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver getEdgeDriver() {
        logger.info("Creating Edge Remote Driver.");
        WebDriverManager.edgedriver().setup();
        return new RemoteWebDriver(this.GRID_URL, new EdgeOptions() {{
            setHeadless(false);
            addArguments("--start-maximized");
            setAcceptInsecureCerts(true);
            setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        }});
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver getChromeDriver() {
        logger.info("Creating Chrome Remote Driver.");
        WebDriverManager.chromedriver().setup();
        return new RemoteWebDriver(this.GRID_URL, new ChromeOptions() {{
            setHeadless(false);
            addArguments("--start-maximized");
            setAcceptInsecureCerts(true);
            setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        }});
    }
}