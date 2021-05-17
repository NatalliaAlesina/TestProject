package utils;

import driver.CustomDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {

    public static void scroolPage(WebElement element) {
        WebDriver driver  = CustomDriver.getWebDriverInstance();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
