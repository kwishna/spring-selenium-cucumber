package com.example.seleniumspring.parallels.passed;

import com.example.seleniumspring.base.SpringBaseTestNGTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JuniorSeniorTests2 extends SpringBaseTestNGTests {

    Logger logger = LoggerFactory.getLogger(JuniorSeniorTests2.class);

    @Autowired
    JuniorEngineer2 juniorEngineer2;

    @Autowired
    SeniorEngineer2 seniorEngineer2;

    @Test
    public void testSalary() {
        this.juniorEngineer2.setSalary(1000);
        this.seniorEngineer2.setSalary(5555);

        logger.info("Asserting Senior Engineer Salary2 For 5555.");
        Assert.assertEquals(5555, this.seniorEngineer2.getSalary(), "Expecting Junior Engineer Salary2 To Be 5555.");

        logger.info("Asserting Junior Engineer Salary2 For 1000.");
        Assert.assertEquals(1000, this.juniorEngineer2.getSalary(), "Expecting Junior Engineer Salary2 To Be 1000.");

    }
}
