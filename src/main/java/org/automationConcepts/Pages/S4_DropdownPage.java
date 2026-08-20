package org.automationConcepts.Pages;

import io.reactivex.rxjava3.internal.operators.observable.BlockingObservableIterable;
import org.automationConcepts.Utilities.DropdownType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;


public class S4_DropdownPage extends BasePage{

    public S4_DropdownPage(WebDriver driver) { super(driver); }
    private static final Logger logger = LoggerFactory.getLogger(S4_DropdownPage.class);

        //Locators
        private final By singleDropdownLocator = By.id("countryDropdown");
        private final By multipleSelectDropdownLocator = By.id("multiSelectDropdown");
        private final By customDropdownLocator = By.id("customDropdown");
        private final By customDropdownOptionsLocator = By.cssSelector("#customOptions div");
        private final By dynamicDropdownLocator = By.id("dynamicDropdown");

        //Actions
        //Standard dropdown
        public S4_DropdownPage selectCountryByText(String country){
            logger.info("Selecting country: " + country);
            selectDropdown(singleDropdownLocator, DropdownType.TEXT, country);
            return this;
        }
        public S4_DropdownPage selectCountryByValue(String value){
            logger.info("Selecting country by value: " + value);
            selectDropdown(singleDropdownLocator, DropdownType.VALUE, value);
            return this;
        }
        public S4_DropdownPage selectCountryByIndex(int index) {
            logger.info("Selecting country by index: " + index);
            selectDropdown(singleDropdownLocator, DropdownType.INDEX, String.valueOf(index));
            return this;
        }

        //Multiple dropdown
        public S4_DropdownPage selectMultipleOptions(String... options){
            logger.info("Selecting multiple options: " + String.join(", ", options));
                selectDropdown(multipleSelectDropdownLocator, DropdownType.TEXT, options);
                return this;
        }

        //Custom dropdown
        public S4_DropdownPage selectCustomOption(String option) {
            logger.info("Selecting custom dropdown option: " + option);
            selectCustomDropdown(customDropdownLocator, customDropdownOptionsLocator, option);
            return this;
        }

        //Dynamic dropdown
        public S4_DropdownPage selectDynamicOption(String option){
            logger.info("Selecting dynamic dropdown option: " + option);
            selectDropdown(dynamicDropdownLocator, DropdownType.TEXT, option);
            return this;
        }

        //Getter methods for assertions
        public String getSelectedCountry(){
            WebElement dropdown = driver.findElement(singleDropdownLocator);
            return new Select(dropdown).getFirstSelectedOption().getText();
        }

        public List<String> getSelectedMultipleOptions(){
        WebElement dropdown = driver.findElement(multipleSelectDropdownLocator);
        Select select = new Select(dropdown);

        return select.getAllSelectedOptions()
                .stream()
                .map(WebElement::getText)
                .toList();
        }

        public String getCustomSelectedValue(){
        return driver.findElement(customDropdownLocator).getText();
         }

        public String getDynamicSelectedValue(){
        return driver.findElement(dynamicDropdownLocator).getAttribute("value");
        }

    }
