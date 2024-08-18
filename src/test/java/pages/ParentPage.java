package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.GWD;

import java.time.Duration;

public class ParentPage {

    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    public Actions driverAction = new Actions(GWD.getDriver());

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) GWD.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void JavaScriptClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        JavascriptExecutor jse = (JavascriptExecutor) GWD.getDriver();
        jse.executeScript("arguments[0].click();", element);
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void verifyContainsText(WebElement element, String value, String attributeName) {
        wait.until(ExpectedConditions.visibilityOf(element));

        String actualValue;
        if (attributeName != null && !attributeName.isEmpty()) {
            actualValue = element.getAttribute(attributeName);
        } else {
            actualValue = element.getText();
        }

        Assert.assertTrue(actualValue.toLowerCase().contains(value.toLowerCase()), "Expected value to be present in the attribute or text.");
    }


    public void ActionHover(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        Action action = driverAction.moveToElement(element).build();
        action.perform();
    }

    public void ActionClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        Action action = driverAction.click(element).build();
        action.perform();
    }

    public void SelectMenuByValue(WebElement element, String value) {
        Select select = new Select(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        select.selectByValue(value);
    }

    public int randomGenerator(int until) {
        return (int) (Math.random() * until);
    }

    public void Wait(int limit) {
        try {
            Thread.sleep(limit * 300L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
