package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class S19_ScrollPage extends BasePage{

    private final By scrollTarget = By.id("scrollTargetBtn");
    public S19_ScrollPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToTargetAndClick(){
        scrollToElement(scrollTarget);
        waitUtil.waitForVisibility(scrollTarget);
        waitUtil.waitForClickable(scrollTarget);
        click(scrollTarget);
    }
}

