package com.example.seleniumspring.core.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/*
// 'TakesScreenshot' Object Within 'ScreenshotUtils' Class Should Be Refreshed Whenever new 'WebDriver' Object Under @Scope('browserscope').

// 1st Way To Fix This Is Putting @Scope("prototype") On ScreenshotUtils Class. So That, TakesScreenshot Object Refreshes Always.
// 2nd Way To Fix This Is Using '@Autowired ApplicationContext appContext' To Fetch 'TakesScreenshot' Bean As Per Our Need.

// Passes During Parallel Execution.
// When 'WebDriver' Has @Scope("browserscope").
*/

// Comment And Uncomment The @Component & @Lazy Tags To Skip This Class From Loading.
@Lazy
//@Component
@Service // Replacement Of @Component. Works Same as @Component
public class ScreenshotService_Passes_On_Parallel_Using_ApplicationContext {
    Logger logger = LoggerFactory.getLogger(ScreenshotService_Passes_On_Parallel_Using_ApplicationContext.class);

    @Autowired
    ApplicationContext applicationContext; // We Will Fetch TakesScreenshot Bean From context As Per Our Need.

    @Value("${screenshot.path}")
    String screenshotDir;

    public boolean takeScreenshot() {
        Path _path = Path.of(screenshotDir, System.currentTimeMillis() + ".png");
        logger.info("Saving Screenshot To --> " + _path);
        File _fileSrc = this.applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(_fileSrc, _path.toFile());
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    public byte[] getScreenshot(){
        return this.applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
