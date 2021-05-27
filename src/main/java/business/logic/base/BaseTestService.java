package business.logic.base;

import driver.Driver;
import po.pages.BasePage;
import utils.DriverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTestService {

    protected ThreadLocal <WebDriver> driver = Driver.getWebDriver();

    protected <T extends BasePage> T initPage(Class <T> clazz)
    {
        T page = PageFactory.initElements(driver.get(), clazz);
        DriverUtils.waitForPageLoad();
        return page;
    }

}
