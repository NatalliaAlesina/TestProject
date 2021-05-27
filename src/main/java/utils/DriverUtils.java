package utils;

import driver.Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

    private static final long waitTimeoutInS = 100;

    static ThreadLocal<WebDriver> driver = Driver.getWebDriver();

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver.get())
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(driver.get());
        actions.moveToElement(element).release().build().perform();
    }

    public static void waitForPageLoad() {
        jsWait(waitTimeoutInS, JavascriptWait.PAGE_LOAD);
    }

    public static void waitForAjax() {
        jsWait(waitTimeoutInS, JavascriptWait.JQUERY_AJAX);
    }

    private static void jsWait(long waitTimeout, JavascriptWait wait) {
        try {
            (new WebDriverWait(driver.get(), waitTimeout))
                    .until((ExpectedCondition<Boolean>) driver -> (Boolean) ((JavascriptExecutor) driver).executeScript(wait.getJavascript()));
        } catch (Exception e) {
            throw new RuntimeException("'Wait' operation timed out after " + waitTimeout + " seconds!", e);
        }
    }
}
