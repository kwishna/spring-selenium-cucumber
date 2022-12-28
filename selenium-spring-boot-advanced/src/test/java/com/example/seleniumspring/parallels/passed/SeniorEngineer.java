package com.example.seleniumspring.parallels.passed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SeniorEngineer {

    Logger logger = LoggerFactory.getLogger(SeniorEngineer.class);

    @Autowired
    private Salary salary;

    public void setSalary(int salary) {
        logger.info("Setting Salary For Senior Engineer: " + salary);
        this.salary.setAmount(salary);
    }

    public int getSalary() {
        logger.info("Getting Salary For Senior Engineer.");
        return this.salary.getAmount();
    }
}
