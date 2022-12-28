package com.example.seleniumspring.googleTestNGParallel_tests;

import com.example.seleniumspring.base.SpringBaseTestNGTests;
import com.example.seleniumspring.core.annotations.LazyAutowired;
import com.example.seleniumspring.core.service.ScreenshotService_Passes_On_Parallel_Using_ApplicationContext;
import com.example.seleniumspring.pages.google.GooglePage;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
    When tests run in parallel. Same object of WebDriver & Other Components Are Shared Among The Tests. Hence, fails!
    To Fix This We Should Annotate Our Components & Beans With @Scope("prototype").
 */
public class Google1Tests extends SpringBaseTestNGTests {
    Logger logger = LoggerFactory.getLogger(Google1Tests.class);

    @LazyAutowired
//    @Lazy
//    @Autowired
    ScreenshotService_Passes_On_Parallel_Using_ApplicationContext screenshotUtils;
//    ScreenshotService_Passes_On_Parallel_Using_Prototype_Scope screenshotUtils; // Can Be Used Too.
    /*
    Even If We Don't Use This In Our Test. Bean Will Be Constructed & Injected (@PostConstruct Annotated Method Will Run).
    Since, Bean Creation Is Time Consuming Process. It Should Not Be Created If It Is Not Getting Used Anywhere.
    To Achieve It We Should Annotate @Component & @Autowired With @Lazy.
    We Can Put @Lazy Over The @Configuration Or @Bean Also..
     */

    @LazyAutowired
//    @Autowired
    GooglePage googlePage;
    @Autowired
    Faker faker;
    @Test
    public void google1Test() {

        // Make Sure "@ConditionalOnProperty" Is Un-commented In All WebDriverConfig Files.
        logger.info("Before googlePage.goTo!!");
        this.googlePage.goTo();

        logger.info("Before googlePage.isAt!!");
        Assert.assertTrue(this.googlePage.isAt());

        logger.info("Before googlePage.getSearchComponent!!");
        this.googlePage.getSearchComponent().search(faker.country().name()+" Hypersonic Missile");

        logger.info("Before googlePage.getSearchResult!!");
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() > 3);

        logger.info("Before screenshotUtils.takeScreenshot!!");
        Assert.assertTrue(screenshotUtils.takeScreenshot(), "Screenshot Failed.");

        logger.info("Current Url --> " + this.googlePage.getCurrentUrl());

        logger.info("Before googlePage.quit!!");
        this.googlePage.quit();
        logger.info("After googlePage.quit!!");
    }
}
