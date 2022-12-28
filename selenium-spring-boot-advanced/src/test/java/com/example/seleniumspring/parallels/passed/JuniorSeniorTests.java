package com.example.seleniumspring.parallels.passed;

import com.example.seleniumspring.base.SpringBaseTestNGTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JuniorSeniorTests extends SpringBaseTestNGTests {

    Logger logger = LoggerFactory.getLogger(JuniorSeniorTests.class);

    @Autowired
    JuniorEngineer juniorEngineer;

    @Autowired
    SeniorEngineer seniorEngineer;

    @Test
    public void testSalary() {
        this.juniorEngineer.setSalary(1000);
        this.seniorEngineer.setSalary(5555);

        logger.info("Asserting Senior Engineer Salary For 5555.");
        Assert.assertEquals(5555, this.seniorEngineer.getSalary(), "Expecting Junior Engineer Salary To Be 5555.");

        logger.info("Asserting Junior Engineer Salary For 1000.");
        Assert.assertEquals(1000, this.juniorEngineer.getSalary(), "Expecting Junior Engineer Salary To Be 1000.");

    }
}
