package org.automationConcepts.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S30_ComplexDOMPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(S30_ComplexDOMPage.class);

    public S30_ComplexDOMPage(WebDriver driver) {
        super(driver);
    }

    private final By complexDOMLocator = By.xpath("//div[@id='section-complex-dom']//button[@id='complexDomButton']");

    public S30_ComplexDOMPage clickComplexDOMButton() {
        logger.info("Clicking on Complex DOM Button");
        scrollToElement(complexDOMLocator);
        click(complexDOMLocator);
        return this;
    }

}
