package driver;

import lombok.extern.slf4j.Slf4j;
import utils.PropertiesFileReader;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public class DriverManager {

    public static WebDriver getDriver(Browsers browser) {

        switch (browser != null ? browser : Browsers.CHROME) {
            case FF:
                return getFirefoxDriver();
            default:
                return getChromeDriver();
        }

    }

    private static WebDriver getFirefoxDriver() {
        RemoteWebDriver webDriver = null;
        try {
            webDriver =
                    new RemoteWebDriver(URI.create(PropertiesFileReader.getRemoteDriverUrl()).toURL(), getRemoteDriverCapabilities("firefox", "75.0"));
            webDriver.manage().window().maximize();
        } catch (MalformedURLException e) {
            log.error("Failed to create the Url" + e.getMessage(), e);
            throw new RuntimeException();
        }
        return webDriver;
    }

    private static WebDriver getChromeDriver() {
        RemoteWebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(URI.create(PropertiesFileReader.getRemoteDriverUrl()).toURL(), getRemoteDriverCapabilities("chrome", "81.0"));
            webDriver.manage().window().maximize();
        } catch (MalformedURLException e) {
            log.error("Failed to create the Url" + e.getMessage(), e);
            throw new RuntimeException();
        }

        return webDriver;
    }

    private static DesiredCapabilities getRemoteDriverCapabilities(String browser, String browserVersion) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", browserVersion);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        return capabilities;
    }
}
