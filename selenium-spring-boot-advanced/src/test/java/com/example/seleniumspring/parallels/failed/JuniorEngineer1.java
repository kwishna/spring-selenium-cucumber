package com.example.seleniumspring.parallels.failed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class JuniorEngineer1 {

    Logger logger = LoggerFactory.getLogger(JuniorEngineer1.class);

    @Autowired
    private Salary1 salary1;

    public void setSalary(int salary) {
        logger.info("Setting Salary2 For Junior Engineer To: " + salary);
        this.salary1.setAmount(salary);
    }

    public int getSalary() {
        logger.info("Getting Salary2 For Junior Engineer.");
        return this.salary1.getAmount();
    }
}
