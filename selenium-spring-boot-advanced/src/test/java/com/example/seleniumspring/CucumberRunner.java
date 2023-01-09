package com.example.seleniumspring;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.example.seleniumspring.bdd",
        tags =  "@visa",
        plugin = {
                "pretty",
                "html:target/cucumber-report/cucumber-report.html",
                "json:target/cucumber-report/cucumber-report.json",
                "junit:target/cucumber-report/cucumber-report.xml",
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
