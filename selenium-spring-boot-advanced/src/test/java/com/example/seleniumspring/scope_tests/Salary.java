package com.example.seleniumspring.scope_tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("prototype")
// @Scope("singleton") // Default scope.
// Singleton --> JuniorSeniorTests Will Fail For 'singleton', Because Same 'Salary' Bean Object Will Shared To 'JuniorEngineer' & 'SeniorEngineer'.
// prototype --> JuniorSeniorTests Will Pass For 'prototype', Because Separate 'Salary' Bean Object Will Shared To 'JuniorEngineer' & 'SeniorEngineer'.
public class Salary {

    Logger logger = LoggerFactory.getLogger(Salary.class);
    private int amount;

    @Override
    public String toString() {
        return "Salary{" +
                "amount=" + amount +
                '}';
    }

    public int getAmount() {
        logger.info("Getting Salary Amount.");
        return amount;
    }

    public void setAmount(int amount) {
        logger.info("Setting Salary Amount: " + amount);
        this.amount = amount;
    }
}
