package com.example.seleniumspring.bdd;

import com.example.seleniumspring.core.annotations.LazyAutowired;
import com.example.seleniumspring.pages.google.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

/*
Q. Why The '@CucumberContextConfiguration' And '@SpringBootTest' Are Present In Only One Step Definition File?
A. Because, Spring Will Treat All The 'CucumberOptions - Glue Folder' Files As Single File. We Should Put These Annotations In Only One Step File.
 */
@CucumberContextConfiguration
@SpringBootTest
public class GoogleSteps {

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on the google site")
    public void launchSite() {
        this.googlePage.goTo();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

    @Then("I should see search results page")
    public void clickSearch() {
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
    }

    @Then("I should see at least {int} results")
    public void verifyResults(int count) {
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() >= count);
    }

}
