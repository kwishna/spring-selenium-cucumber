package com.example.seleniumspring.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public abstract class AbstractBasePage {

    @Lazy
    @Autowired
    protected WebDriver driver;
    @Lazy
    @Autowired
    protected WebDriverWait wait;
    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }
    public abstract boolean isAt();
    public void quit() {
        this.driver.quit();
    }
}
