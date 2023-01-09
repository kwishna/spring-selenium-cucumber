package com.example.seleniumspring.scope_tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class JuniorEngineer {

    Logger logger = LoggerFactory.getLogger(JuniorEngineer.class);

    @Autowired
    private Salary salary;

    public void setSalary(int salary) {
        logger.info("Setting Salary2 For Junior Engineer To: " + salary);
        this.salary.setAmount(salary);
    }

    public int getSalary() {
        logger.info("Getting Salary2 For Junior Engineer.");
        return this.salary.getAmount();
    }
}
