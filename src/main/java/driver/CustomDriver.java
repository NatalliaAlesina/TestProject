package driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CustomDriver {

    private static RemoteWebDriver driver;

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "81.0");
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            try {
                driver = new RemoteWebDriver(URI.create("http://34.73.225.6:4444/wd/hub").toURL(), capabilities);
                driver.manage().window().maximize();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void stopBrowser() {
        if (null != driver){
            driver.manage().deleteAllCookies();
            driver.quit();
            System.out.println("Browser was successfully quited.");
        }
        driver = null;
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
