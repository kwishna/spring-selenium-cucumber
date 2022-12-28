package com.example.seleniumspring.googleTestNGmultiple.failed;

import com.example.seleniumspring.pages.google.GooglePage;
import com.example.seleniumspring.SpringBaseTestNGTests;
import com.example.seleniumspring.utils.ScreenshotUtils;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
    When tests run in parallel. Same object of WebDriver & Other Components Are Shared Among The Tests. Hence, fails!
    To Fix This We Should Annotate Our Components & Beans With @Scope("prototype").
 */
public class Google2Tests extends SpringBaseTestNGTests {
    Logger logger = LoggerFactory.getLogger(Google2Tests.class);
    @Lazy
    @Autowired
    ScreenshotUtils screenshotUtils;
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
    public void google2Test() {
        logger.info("Before googlePage.goTo!!");
        this.googlePage.goTo();

        logger.info("Before googlePage.isAt!!");
        Assert.assertTrue(this.googlePage.isAt());

        logger.info("Before googlePage.getSearchComponent!!");
        this.googlePage.getSearchComponent().search(faker.country().name()+" - India Relations");

        logger.info("Before googlePage.getSearchResult!!");
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() > 3);

        logger.info("Before screenshotUtils.takeScreenshot!!");
        Assert.assertTrue(screenshotUtils.takeScreenshot(), "Screenshot Failed.");

        logger.info("Before googlePage.quit!!");
        this.googlePage.quit();
        logger.info("After googlePage.quit!!");
    }
}
