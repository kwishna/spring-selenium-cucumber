package com.example.seleniumspring.parallels.failed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SeniorEngineer1 {

    Logger logger = LoggerFactory.getLogger(SeniorEngineer1.class);

    @Autowired
    private Salary1 salary;

    public void setSalary(int salary) {
        logger.info("Setting Salary For Senior Engineer: " + salary);
        this.salary.setAmount(salary);
    }

    public int getSalary() {
        logger.info("Getting Salary For Senior Engineer.");
        return this.salary.getAmount();
    }
}
