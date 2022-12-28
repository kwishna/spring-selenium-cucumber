package com.example.seleniumspring.googleJunit4Single;

import com.example.seleniumspring.pages.google.GooglePage;
import com.example.seleniumspring.utils.ScreenshotUtils;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { SpringTestConfiguration.class })
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { SpringTestConfiguration.class })

@SpringBootTest
@RunWith(SpringRunner.class)
public class Google3Tests {
    Logger logger = LoggerFactory.getLogger(Google3Tests.class);
    @Lazy
    @Autowired
    ScreenshotUtils screenshotUtils;
    /*
    Even If We Don't Use This In Our Test. Bean Will Be Constructed & Injected (@PostConstruct Annotated Method Will Run).
    Since, Bean Creation Is Time Consuming Process. It Should Not Be Created If It Is Not Getting Used Anywhere.
    To Achieve It We Should Annotate @Component & @Autowired With @Lazy.
    We Can Put @Lazy Over The @Configuration Or @Bean Also.
     */
    @Autowired
    GooglePage googlePage;
    @Autowired
    Faker faker;
    @Test
    public void google1Test() {
        logger.info("Before googlePage.goTo!!");
        this.googlePage.goTo();

        logger.info("Before googlePage.isAt!!");
        Assert.assertTrue(this.googlePage.isAt());

        logger.info("Before googlePage.getSearchComponent!!");
        this.googlePage.getSearchComponent().search(faker.country().name()+" Hypersonic Missile");

        logger.info("Before googlePage.getSearchResult!!");
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() > 3);

        logger.info("Before screenshotUtils.takeScreenshot!!");
        Assert.assertTrue("Screenshot Failed.", screenshotUtils.takeScreenshot());

        logger.info("Before googlePage.quit!!");
        this.googlePage.quit();
        logger.info("After googlePage.quit!!");
    }
}
