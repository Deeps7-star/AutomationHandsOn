package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S14_HoverElementsPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(S14_HoverElementsPage.class);
    public S14_HoverElementsPage(WebDriver driver) {
        super(driver);
    }

    private final By hoverableElement = By.cssSelector("#section-hover .menu");
    private final By subMenu = By.xpath("//div[@class='submenu']/div[text()='Submenu Item 1']");

    public void hoverOverElement(){
        hoverAndClick(hoverableElement, subMenu);

    }

}
