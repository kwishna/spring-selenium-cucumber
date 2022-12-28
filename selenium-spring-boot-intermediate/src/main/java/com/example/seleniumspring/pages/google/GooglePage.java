package com.example.seleniumspring.pages.google;

import com.example.seleniumspring.core.annotations.Page;
import com.example.seleniumspring.pages.AbstractBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends AbstractBasePage {

    Logger logger = LoggerFactory.getLogger(GooglePage.class);

    @Value("${application.url}")
    private String baseUrl;

    @Autowired
    private SearchComponent searchComponent;
    @Autowired
    private SearchResult searchResult;

    public void goTo() {
        logger.info("Navigating to " + baseUrl);
        this.driver.get(this.baseUrl);
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
