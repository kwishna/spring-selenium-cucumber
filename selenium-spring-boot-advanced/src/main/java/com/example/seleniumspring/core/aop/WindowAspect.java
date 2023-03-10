package com.example.seleniumspring.core.aop;

import com.example.seleniumspring.core.annotations.Window;
import com.example.seleniumspring.core.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    /*
    This method will be executed before any method is called from any class annotations with @Window and if it is
    present in package "com.udemy.spring.springselenium."
     */
    @Before("@target(window) && within(com.udemy.spring.springselenium..*)")
    public void before(Window window){
        this.switchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.udemy.spring.springselenium..*)")
    public void after(Window window){
        this.switchService.switchByIndex(0);
    }

}
