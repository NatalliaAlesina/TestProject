package utils;

import driver.CustomDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ScreenshotUtils {

    public static void makeScreenshot() {
        WebDriver driver  = CustomDriver.getWebDriverInstance();
        File successScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.moveFile(successScreenshot, new File("target\\Screenshots\\screenshot_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0)) + ".png"));
            FileUtils.copyFileToDirectory(successScreenshot, new File ("target\\Screenshots"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
