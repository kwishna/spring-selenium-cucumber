package com.example.seleniumspring.core.annotations;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Lazy
@Component
@Documented
//@Scope("prototype") // Created Object For Each @Component On Every Request. Problems - It Creates Too Many Driver Instances.
//@Scope("singleton") // Same Object For Each @Component On Every Request. Problems - It Creates Only One Driver Instance.
// Both 'singleton' and 'prototype' scope does not work properly for our WebDriver.
//@Scope("prototype") // Same Object For Each @Component On Every Request.
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Page {
}
