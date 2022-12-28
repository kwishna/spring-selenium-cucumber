package com.example.seleniumspring.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class ScreenshotUtils {

    Logger logger = LoggerFactory.getLogger(ScreenshotUtils.class);

    @Autowired
    TakesScreenshot driver;

    @Value("${screenshot.path}")
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
