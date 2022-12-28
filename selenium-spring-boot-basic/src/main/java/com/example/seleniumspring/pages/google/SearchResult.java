package com.example.seleniumspring.pages.google;

import com.example.seleniumspring.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Lazy
@Component
public class SearchResult extends AbstractBasePage {

    Logger logger = LoggerFactory.getLogger(SearchResult.class);

    @FindBy(css = "div.g a h3")
    private List<WebElement> results;

    public int getResultCount() {
        logger.info("Fetching Search Result Count: " + results.size());
        return results.size();
    }

    @Override
    public boolean isAt() {
        logger.info("Wait For Successful Navigation To Google Result Page.");
        return this.wait.until((d) -> !this.results.isEmpty());
    }
}
