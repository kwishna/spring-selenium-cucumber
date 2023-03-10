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
// Singleton --> JuniorSeniorTests2 Will Fail For 'singleton', Because Same 'Salary2' Bean Object Will Shared To 'JuniorEngineer2' & 'SeniorEngineer2'.
// prototype --> JuniorSeniorTests2 Will Pass For 'prototype', Because Separate 'Salary2' Bean Object Will Shared To 'JuniorEngineer2' & 'SeniorEngineer2'.
public class Salary {

    Logger logger = LoggerFactory.getLogger(Salary.class);
    private int amount;

    @Override
    public String toString() {
        return "Salary2{" +
                "amount=" + amount +
                '}';
    }

    public int getAmount() {
        logger.info("Getting Salary2 Amount.");
        return amount;
    }

    public void setAmount(int amount) {
        logger.info("Setting Salary2 Amount: " + amount);
        this.amount = amount;
    }
}
