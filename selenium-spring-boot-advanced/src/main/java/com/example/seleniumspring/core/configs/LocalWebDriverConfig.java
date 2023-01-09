package com.example.seleniumspring.core.configs;

import com.example.seleniumspring.core.annotations.LazyConfiguration;
import com.example.seleniumspring.core.annotations.ThreadScopeBean;
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
import org.springframework.context.annotation.*;

import java.time.Duration;

@LazyConfiguration
@Profile("!remote")
public class LocalWebDriverConfig {

    Logger logger = LoggerFactory.getLogger(LocalWebDriverConfig.class);

    @Value("${browser:chrome}")
    private String browser;

    @Value("${headless:true}")
    private boolean headless;

    @ThreadScopeBean // This Is Custom Annotation
//    @Bean // ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("browserscope") // Custom scope - ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("prototype") // Creates Separate Object For Each @Autowired. Not Useful - Created So Many Drivers.
    public WebDriver getDriver() {
        logger.info("Getting Local Driver For Browser: "+this.browser);
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
      @ThreadScopeBean
//    @Bean // ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("browserscope") // Custom scope - ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("prototype") // Creates Separate Object For Each @Autowired. Not Useful - Created So Many Drivers.
    @Primary // When Multiple @Bean Returns 'WebDriver' Leading To @Autowire Conflict.
    public WebDriver getEdgeDriver() {
        WebDriver driver = this.getEdge();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
*/

/*
      @ThreadScopeBean
//    @Bean // ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("browserscope") // Custom scope - ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("prototype") // Creates Separate Object For Each @Autowired. Not Useful - Created So Many Drivers.
    @ConditionalOnProperty(name = "browserName", value = "firefox") // When 'browserName' Property Is Set to 'firefox'.
    public WebDriver getFirefoxDriver() {
        WebDriver driver = this.getFirefox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @ThreadScopeBean
//    @Bean // ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("browserscope") // Custom scope - ##Moved To Custom Annotation @ThreadScopeBean
//    @Scope("prototype") // Creates Separate Object For Each @Autowired. Not Useful - Created So Many Drivers.
    @ConditionalOnMissingBean // When 'browserName' Property is missing.
    public WebDriver getChromeDriver() {
        WebDriver driver = this.getChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
     }
*/

}
