package com.example.seleniumspring.core.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/*

// Commented As If Fails During Parallel Execution.

// Fails During Parallel Execution.
// Even When 'WebDriver' Has @Scope("browserscope") Or, @Scope("prototype") Or, @Scope("singleton").
// 1st Way To Fix This Is Putting @Scope("prototype") On This Class.
//// 2nd Way To Fix This Is Using '@Autowired ApplicationContext appContext' To Fetch 'TakesScreenshot' Bean As Per Our Need.
@Lazy
//@Component
@Service // Replacement Of @Component. Works Same as @Component
*/

public class ScreenshotService_Fails_On_Parallel {

    Logger logger = LoggerFactory.getLogger(ScreenshotService_Fails_On_Parallel.class);

//    @Autowired
    TakesScreenshot driver; // Fails Here During Parallel Execution. When 'WebDriver' Has @Scope("browserscope") Or, @Scope("prototype") Or, @Scope("singleton").

//    @Value("${screenshot.path}")
    String screenshotDir;

    public boolean takeScreenshot() {
        Path path = Path.of(screenshotDir, System.currentTimeMillis() +".png");
        logger.info("Saving Screenshot To --> " + path);
        File _fileSrc = this.driver.getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(_fileSrc, path.toFile());
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }
}
