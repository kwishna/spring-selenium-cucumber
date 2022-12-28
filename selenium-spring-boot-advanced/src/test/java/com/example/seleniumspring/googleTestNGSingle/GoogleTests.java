package com.example.seleniumspring.googleTestNGSingle;


import com.example.seleniumspring.base.SpringBaseTestNGTests;
import com.example.seleniumspring.core.service.ScreenshotService_Passes_On_Parallel_Using_ApplicationContext;
import com.example.seleniumspring.pages.google.GooglePage;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTests extends SpringBaseTestNGTests {
    Logger logger = LoggerFactory.getLogger(GoogleTests.class);
    @Lazy
    @Autowired
    ScreenshotService_Passes_On_Parallel_Using_ApplicationContext screenshotUtils;
    /*
    Even If We Don't Use This In Our Test. Bean Will Be Constructed & Injected (@PostConstruct Annotated Method Will Run).
    Since, Bean Creation Is Time Consuming Process. It Should Not Be Created If It Is Not Getting Used Anywhere.
    To Achieve It We Should Annotate @Component & @Autowired With @Lazy.
    We Can Put @Lazy Over The @Configuration Or @Bean Also..
     */
    @Autowired
    GooglePage googlePage;

    @Autowired
    Faker faker;

    @Test
    public void googleTest() {
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

        logger.info("Before googlePage.quit!!");
        this.googlePage.quit();
        logger.info("After googlePage.quit!!");
    }
}
