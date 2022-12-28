package com.example.seleniumspring.core.configs;

import com.example.seleniumspring.core.annotations.LazyConfiguration;
import com.example.seleniumspring.core.annotations.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.net.URL;
import java.time.Duration;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {

    Logger logger = LoggerFactory.getLogger(RemoteWebDriverConfig.class);

    @Value("${selenium.grid.url}")
    private URL GRID_URL;

    @ThreadScopeBean
//    @Bean // ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("browserscope") // Custom scope - ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("prototype")  // Creates Separate Object For Each @Autowired. Not Useful - Created So Many Drivers.
    @ConditionalOnProperty(name = "browser", havingValue = "firefox") // Applicable Only For '@Autowired WebDriver driver' Injection. Not For --> this.applicationContext.getBean("getFirefoxDriver", WebDriver.class)
    public WebDriver getFirefoxDriver() {
        logger.info("Creating Firefox Remote Driver.");
        WebDriverManager.firefoxdriver().setup();
        return new RemoteWebDriver(this.GRID_URL, new FirefoxOptions() {{
            setHeadless(false);
            addArguments("--start-maximized");
            setAcceptInsecureCerts(true);
            setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            setImplicitWaitTimeout(Duration.ofSeconds(10));
        }});
    }

    @ThreadScopeBean
//    @Bean // ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("browserscope") // Custom scope - ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("prototype")  // Creates Separate Object For Each @Autowired. Not Useful - Created So Many Drivers.
    @ConditionalOnProperty(name = "browser", havingValue = "edge") // Applicable For @Autowired Injection. Not For --> this.applicationContext.getBean("getEdgeDriver", WebDriver.class);
    public WebDriver getEdgeDriver() {
        logger.info("Creating Edge Remote Driver.");
        WebDriverManager.edgedriver().setup();
        return new RemoteWebDriver(this.GRID_URL, new EdgeOptions() {{
            setHeadless(false);
            addArguments("--start-maximized");
            setAcceptInsecureCerts(true);
            setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            setImplicitWaitTimeout(Duration.ofSeconds(10));
        }});
    }

    @ThreadScopeBean
//    @Bean // ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("browserscope") // Custom scope - ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("prototype") // Creates Separate Object For Each @Autowired. Not Useful - Created So Many Drivers.
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome") // Applicable For @Autowired Injection. Not For --> this.applicationContext.getBean("getChromeDriver", WebDriver.class);
    public WebDriver getChromeDriver() {
        logger.info("Creating Chrome Remote Driver.");
        WebDriverManager.chromedriver().setup();
        return new RemoteWebDriver(this.GRID_URL, new ChromeOptions() {{
            setHeadless(false);
            addArguments("--start-maximized");
            setAcceptInsecureCerts(true);
            setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            setImplicitWaitTimeout(Duration.ofSeconds(10));
        }});
    }
}