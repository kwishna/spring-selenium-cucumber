package com.example.seleniumspring.pages.google;

import com.example.seleniumspring.core.annotations.PageFragment;
import com.example.seleniumspring.pages.AbstractBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@PageFragment
public class SearchComponent extends AbstractBasePage {

    Logger logger = LoggerFactory.getLogger(SearchComponent.class);

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    @Override
    public boolean isAt() {
        logger.info("Wait For Successful Navigation To Google Search Page.");
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }

    public void search(final String keyword) {
        this.searchBox.clear();
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns
                .stream()
                .filter(_el -> _el.isDisplayed() && _el.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
