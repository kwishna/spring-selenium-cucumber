package com.example.seleniumspring.parallels.passed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class JuniorEngineer2 {

    Logger logger = LoggerFactory.getLogger(JuniorEngineer2.class);

    @Autowired
    private Salary2 salary2;

    public void setSalary(int salary) {
        logger.info("Setting Salary2 For Junior Engineer To: " + salary);
        this.salary2.setAmount(salary);
    }

    public int getSalary() {
        logger.info("Getting Salary2 For Junior Engineer.");
        return this.salary2.getAmount();
    }
}
