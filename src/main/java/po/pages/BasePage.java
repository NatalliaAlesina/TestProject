package po.pages;

import driver.Driver;
import utils.DriverUtils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    @FindBy(xpath = "//nav[@id='eed-nav']//*[text()='Shop']")
    protected WebElement shopButton;

    @FindBy(xpath = "//nav[@id='eed-nav']//*[text()='My Shop']")
    protected WebElement myShopButton;

    @FindBy(xpath = "//ul[@class='eed-off-nav-menu__sub']//a[text()='Phones']")
    private WebElement phonesButton;

    @FindBy(xpath = "//nav[@id='eed-nav']//*[text()='All phones']")
    protected WebElement allPhonesButton;

    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 70;

    protected ThreadLocal<WebDriver> driver = Driver.getWebDriver();

    protected <T extends BasePage> T initPage(Class<T> clazz) {
        T page = PageFactory.initElements(driver.get(), clazz);
        DriverUtils.waitForPageLoad();
        return page;
    }

    public void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver.get(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementEnabled(WebElement element) {
        new WebDriverWait(driver.get(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement getPhonesButton() {
        return phonesButton;
    }

    public WebElement getShopButton() {
        return shopButton;
    }

    public boolean isDisplayed(WebElement webElement) {
        boolean isDisplayed = true;
        try {
            isDisplayed = webElement.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver.get());
        actions.moveToElement(element).perform();
    }
}

