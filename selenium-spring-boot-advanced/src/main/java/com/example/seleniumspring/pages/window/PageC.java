package com.example.seleniumspring.pages.window;

import com.example.seleniumspring.core.annotations.Window;
import com.example.seleniumspring.pages.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page C")
public class PageC  extends AbstractBasePage {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg){
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.textArea.isDisplayed());
    }
}
