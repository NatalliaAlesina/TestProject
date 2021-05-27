package base;

import business.logic.base.BaseTestModule;
import driver.Driver;
import utils.DriverUtils;
import utils.PropertiesFileReader;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Injector injector = Guice.createInjector(new BaseTestModule());

    @BeforeMethod(alwaysRun = true, description = "Start browser")
    public void performPreconditions() {
        injector.injectMembers(this);
        Driver.getWebDriver().get().get(PropertiesFileReader.getWebSiteUrl());
        DriverUtils.waitForPageLoad();
        DriverUtils.waitForAjax();
    }

    @AfterMethod(alwaysRun = true, description = "Stop Browser")
    public void closeBrowser() {
        Driver.tearDown();
    }
}
