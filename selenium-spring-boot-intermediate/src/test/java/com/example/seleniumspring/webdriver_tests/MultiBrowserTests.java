package com.example.seleniumspring.webdriver_tests;

import com.example.seleniumspring.base.SpringBaseTestNGTests;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

// Make Sure To Comment '@ConditionalOnProperty()' In '*WebDriverConfig' Class
public class MultiBrowserTests extends SpringBaseTestNGTests {

    Logger logger = LoggerFactory.getLogger(MultiBrowserTests.class);

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void browserTest() {
        WebDriver firefox = this.applicationContext.getBean("getFirefoxDriver", WebDriver.class);
        firefox.get("https://google.co.in/q?qa");

        WebDriver chrome = this.applicationContext.getBean("getChromeDriver", WebDriver.class);
        chrome.get("https://google.co.in/q?uat");

        Assert.assertEquals(firefox.getCurrentUrl(), "https://google.co.in/q?qa");
        Assert.assertEquals(chrome.getCurrentUrl(), "https://google.co.in/q?uat");
    }
}
