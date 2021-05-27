package driver;

import lombok.extern.slf4j.Slf4j;
import utils.BrowserSettingsReader;

import org.openqa.selenium.WebDriver;

@Slf4j
public class Driver {

    private static final ThreadLocal<WebDriver> WEB_DRIVER_HANDLER = new ThreadLocal<>();

    private static Browsers driverConfig = BrowserSettingsReader.initSettings().getBrowsers();

    public static ThreadLocal<WebDriver> getWebDriver() {
        if (WEB_DRIVER_HANDLER.get() == null) {
            log.info("Get new driver");
            WEB_DRIVER_HANDLER.set(DriverManager.getDriver(driverConfig));
        }
        return WEB_DRIVER_HANDLER;
    }

    public static void tearDown() {
        WEB_DRIVER_HANDLER.get().close();
        WEB_DRIVER_HANDLER.set(null);
    }

}

