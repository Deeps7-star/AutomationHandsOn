package org.automationConcepts.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.LinkedHashMap;
import java.util.Map;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S26_KeyboardActionsPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(S26_KeyboardActionsPage.class);
    public S26_KeyboardActionsPage(WebDriver driver) {
        super(driver);
    }

    private final By keyboardInputLocator = By.xpath("//*[@id='keyboardInput']");
    private final By resultLocator = By.cssSelector("#keyboardResult");

    public Map<String, String> performKeyboardNavigationAndGetResults() {

        Map<String, String> results = new LinkedHashMap<>();

        click(keyboardInputLocator);

        Actions actions = new Actions(driver);

        actions.moveToElement(find(keyboardInputLocator)).click().perform();

        actions.sendKeys(Keys.ARROW_UP).perform();
        results.put("ARROW_UP", getText(resultLocator));

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        results.put("ARROW_DOWN", getText(resultLocator));

        actions.sendKeys(Keys.ARROW_LEFT).perform();
        results.put("ARROW_LEFT", getText(resultLocator));

        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        results.put("ARROW_RIGHT", getText(resultLocator));

        return results;
    }

    public String getResultText() {
        String result = getText(resultLocator);
        logger.info("Result text retrieved: {}", result);
        return result;
    }
}
