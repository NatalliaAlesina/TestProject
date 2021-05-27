package utils;

import driver.BrowserSettings;
import driver.Browsers;

import org.apache.commons.lang3.StringUtils;

public class BrowserSettingsReader {

    public static BrowserSettings initSettings() {
        BrowserSettings settings = BrowserSettings.getInstance();

        String browser = System.getProperty("browser");

        settings.setBrowsers(StringUtils.isEmpty(browser) ? Browsers.CHROME
                                                          : Browsers.valueOf(browser));
        return settings;

    }
}
