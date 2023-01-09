package com.example.seleniumspring.core.aop;

import com.example.seleniumspring.core.annotations.TakeScreenshot;
import com.example.seleniumspring.core.service.ScreenshotService_Passes_On_Parallel_Using_ApplicationContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenshotService_Passes_On_Parallel_Using_ApplicationContext screenshotService;

    /*
    Executed After Any Method Which Has @TakeScreenshot Annotation
     */
    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException {
        this.screenshotService.takeScreenshot();
    }

}
