package com.example.seleniumspring.scope_tests;

import com.example.seleniumspring.base.SpringBaseTestNGTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JuniorSeniorTests extends SpringBaseTestNGTests {

    Logger logger = LoggerFactory.getLogger(JuniorSeniorTests.class);

    @Autowired
    ApplicationContext ctx;

    @Autowired
    JuniorEngineer juniorEngineer;

    @Autowired
    SeniorEngineer seniorEngineer;

    @Test
    public void testSalary1() {
        this.juniorEngineer.setSalary(1000);
        this.seniorEngineer.setSalary(5555);

        logger.info("Asserting Senior Engineer Salary2 For 5555.");
        Assert.assertEquals(5555, this.seniorEngineer.getSalary(), "Expecting Junior Engineer Salary2 To Be 5555.");

        logger.info("Asserting Junior Engineer Salary2 For 1000.");
        Assert.assertEquals(1000, this.juniorEngineer.getSalary(), "Expecting Junior Engineer Salary2 To Be 1000.");

    }
}
