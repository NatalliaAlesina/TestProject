package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.CustomDriver;
import po.pages.HomePage;

public class BaseTest {

    @BeforeMethod(alwaysRun = true, description = "Start browser")
    public void performPreconditions(){
        openBrowser();
        openHomePage().closeCookieBanner();
    }

    @AfterMethod(alwaysRun = true, description = "Stop Browser")
    public void stopBrowser() {
        CustomDriver.stopBrowser();
    }

    public static WebDriver openBrowser() {
        return CustomDriver.getWebDriverInstance();
    }

    public HomePage openHomePage() {
        CustomDriver.getWebDriverInstance().get("https://shop.ee.co.uk/");
        return new HomePage(CustomDriver.getWebDriverInstance());
    }
}
