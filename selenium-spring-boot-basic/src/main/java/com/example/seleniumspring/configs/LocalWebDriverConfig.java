package com.example.seleniumspring.configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.time.Duration;

@Lazy
@Configuration
@Profile("!remote")
public class LocalWebDriverConfig {

    Logger logger = LoggerFactory.getLogger(LocalWebDriverConfig.class);

    @Value("${browser:chrome}")
    private String browser;

    @Value("${headless:true}")
    private boolean headless;

    @Bean
    @Lazy
    public WebDriver getDriver() {
        logger.info("Getting Driver For Browser: "+this.browser);
        WebDriver driver;
        if (this.browser.equalsIgnoreCase("firefox")) {
            driver = this.getFirefox();
        } else if (this.browser.equalsIgnoreCase("edge")) {
            driver = this.getEdge();
        } else {
            driver = this.getChrome();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(new ChromeOptions() {{
            setHeadless(headless);
        }});
    }

    public WebDriver getFirefox() {
        WebDriverManager.firefoxdriver().driverVersion("0.32.0").setup();
        return new FirefoxDriver(new FirefoxOptions() {{
            setHeadless(headless);
        }});
    }

    public WebDriver getEdge() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(new EdgeOptions() {{
            setHeadless(headless);
        }});
    }

/*
    @Bean
    @Primary // When Multiple @Bean Returns 'WebDriver' Leading To @Autowire Conflict.
    public WebDriver getEdgeDriver() {
        WebDriver driver = this.getEdge();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
*/

/*
    @Bean
    @ConditionalOnProperty(name = "browserName", value = "firefox") // When 'browserName' Property Is Set to 'firefox'.
    public WebDriver getFirefoxDriver() {
        WebDriver driver = this.getFirefox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    @ConditionalOnMissingBean // When 'browserName' Property is missing.
    public WebDriver getChromeDriver() {
        WebDriver driver = this.getChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
     }
*/

}
