package com.example.seleniumspring.parallels.failed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Salary1 {

    Logger logger = LoggerFactory.getLogger(Salary1.class);
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
