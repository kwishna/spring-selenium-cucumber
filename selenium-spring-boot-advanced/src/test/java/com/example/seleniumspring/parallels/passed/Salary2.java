package com.example.seleniumspring.parallels.passed;

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
public class Salary2 {

    Logger logger = LoggerFactory.getLogger(Salary2.class);
    private int amount2;

    @Override
    public String toString() {
        return "Salary2{" +
                "amount=" + amount2 +
                '}';
    }

    public int getAmount() {
        logger.info("Getting Salary2 Amount.");
        return amount2;
    }

    public void setAmount(int amount) {
        logger.info("Setting Salary2 Amount: " + amount);
        this.amount2 = amount;
    }
}
