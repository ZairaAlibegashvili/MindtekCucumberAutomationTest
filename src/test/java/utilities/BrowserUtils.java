package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {
    public static void takeScreenshot(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/" + testName + ".png";
        File file = new File(path);
        FileUtils.copyFile(screenshot, file);

    }

    public static void selectDropdownByValue(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    public static void selectDropDownByValue(WebElement dropDown, String value) {
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method will create a WebdriverWait object and wait for certain
     * text to be presented in a WebElement
     * ex:
     * .waitForTextToBePresentInElement(WebElement element,String expectedText);
     */
    public static void waitForTextToBePresentedInElement(WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));

    }

    /**
     * This method waits element to be clickable
     * Ex:
     * .waitForElementToBeClickable(element)
     *
     * @param element
     */
    public static void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    /**
     * This method scrolls down by[num] px
     * Ex:
     * .scrollDownBy(int)

     */
    public static void scrollDownBy(Integer numOfPixels){
        JavascriptExecutor jse=((JavascriptExecutor) Driver.getDriver());
        jse.executeScript("window.scrollBy(0,"+numOfPixels+")");
    }
}