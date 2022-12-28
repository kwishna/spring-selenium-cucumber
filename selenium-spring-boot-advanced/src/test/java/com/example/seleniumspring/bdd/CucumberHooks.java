package com.example.seleniumspring.bdd;

import com.example.seleniumspring.core.annotations.LazyAutowired;
import com.example.seleniumspring.core.service.ScreenshotService_Passes_On_Parallel_Using_ApplicationContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService_Passes_On_Parallel_Using_ApplicationContext screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
            //scenario.embed(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }

}
