package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class S15_ToolTipPage extends BasePage{
    private static final Logger logger = Logger.getLogger(S15_ToolTipPage.class.getName());
    public S15_ToolTipPage(WebDriver driver) {
        super(driver);
    }

    private final By tooltipHover = By.xpath("//div[contains(@class,'tooltip-container')]");
    private final By tooltipText = By.xpath("//div[@class='tooltip']");

    public String validateTooltip() {
        logger.info("Hovering and validating tooltip");
        return hoverAndGetTooltip(tooltipHover, tooltipText);
    }
}

