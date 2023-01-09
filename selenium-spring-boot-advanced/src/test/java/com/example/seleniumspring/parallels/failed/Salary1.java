package com.example.seleniumspring.parallels.failed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Salary1 {

    Logger logger = LoggerFactory.getLogger(Salary1.class);
    private int amount1;

    @Override
    public String toString() {
        return "Salary2{" +
                "amount=" + amount1 +
                '}';
    }

    public int getAmount() {
        logger.info("Getting Salary2 Amount.");
        return amount1;
    }

    public void setAmount(int amount) {
        logger.info("Setting Salary2 Amount: " + amount);
        this.amount1 = amount;
    }
}
