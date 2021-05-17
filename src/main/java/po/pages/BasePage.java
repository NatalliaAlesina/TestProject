package po.pages;

import driver.CustomDriver;
import utils.HighlightUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    @FindBy(xpath = "//nav[@id='eed-nav']//*[text()='Shop']")
    private WebElement shopButton;

    @FindBy(xpath = "//nav[@id='eed-nav']//*[text()='My Shop']")
    protected WebElement myShopButton;

    @FindBy(xpath = "//ul[@class='eed-off-nav-menu__sub']//a[text()='Phones']")
    private WebElement phonesButton;

    @FindBy(xpath = "//nav[@id='eed-nav']//*[text()='All phones']")
    protected WebElement allPhonesButton;

    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = CustomDriver.getWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    public void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementEnabled(WebElement element) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
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
}

