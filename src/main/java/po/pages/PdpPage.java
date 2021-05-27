package po.pages;

import utils.DriverUtils;
import utils.ScreenshotUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PdpPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-capacity-size margin-top-4 hide-md']//a[@aria-label='256GB']")
    private WebElement capacity256DropDown;
    @FindBy(xpath = "//div[@class='premium-delivery-info__description']//a[@rel='nofollow']")
    private WebElement checkPostCodeBox;
    @FindBy(xpath = "//span[@class='ee-form-control']//input[@type='text']")
    private WebElement enterPostCodeField;
    @FindBy(css = "span.psCheckerCheckPostCodeIcon.ee-icon-search")
    private WebElement searchButton;
    @FindBy(xpath = "//div[contains(@class, 'plan-item--best-top')]//span[@data-content-id='upfrontblock-now']")
    public WebElement upfrontCost;
    @FindBy(css = "div.ps-checker-message__title.ps-checker-message__title--error")
    public WebElement errorMessage;
    @FindBy(css = "div.ps-checker-message__title.ps-checker-message__title--success")
    public WebElement successMessage;
    @FindBy(xpath = "//div[@class='ee-personalized-banner__info']//a[@rel='nofollow']")
    private WebElement loginLink;
    @FindBy(xpath = "//form[@id='command']//button[@class='btn choose-plan-button    js-hero-plan']")
    private WebElement choosePlanButton;
    @FindBy(xpath = "//label[@class='boxed_radio_label boxed_input_label']//*[text()='Pay as you go']")
    private static WebElement payAsYouGoPhonesCheckBox;
    @FindBy(xpath = "//label[@title='£0-£49.99']//span[@class='checkbox']")
    private static WebElement upfrontCost1CheckBox;
    @FindBy(xpath = "//label[@title='MobiWire']//span[@class='checkbox']")
    private static WebElement mobiWireCheckBox;
    @FindBy(xpath = "//label[@title='4GB']//span[@class='checkbox']")
    private static WebElement capacityCheckBox1;
    @FindBy(xpath = "//ul[@id='show']//*[text()='View MobiWire Kanuna details']")
    private static WebElement mobiWireKanunaPhoneBox;

    public PdpPage select256GbCapacity() {
        waitForElementVisible(capacity256DropDown);
        capacity256DropDown.click();
        DriverUtils.waitForPageLoad();
        return this;
    }

    public PdpPage clickCheckPostCodeBox() {
        checkPostCodeBox.click();
        return this;
    }

    public PdpPage enterPostCode(String postcode) {
        waitForElementVisible(enterPostCodeField);
        enterPostCodeField.clear();
        enterPostCodeField.sendKeys(postcode);
        return this;
    }

    public PdpPage clickSearchButton() {
        waitForElementVisible(searchButton);
        searchButton.click();
        return this;
    }

    public boolean checkPostCode(String postcode) {
        clickCheckPostCodeBox();
        enterPostCode(postcode);
        clickSearchButton();
        WebDriverWait wait = new WebDriverWait(driver.get(), 10);
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(errorMessage), ExpectedConditions.visibilityOf(successMessage)));
        ScreenshotUtils.makeScreenshot();

        if (successMessage.isDisplayed()) {
            return true;
        }

        return false;

    }

    public ExtrassPage openExtrass() {
        choosePlanButton.click();
        return initPage(ExtrassPage.class);
    }

    public WebElement getUpfrontCost() {
        return upfrontCost;
    }

    public static WebElement getUpfrontCost1CheckBox() {
        return upfrontCost1CheckBox;
    }

    public static WebElement getMobiWireCheckBox() {
        return mobiWireCheckBox;
    }

    public static WebElement getCapacityCheckBox1() {
        return capacityCheckBox1;
    }

    public static WebElement getMobiWireKanunaPhoneBox() {
        return mobiWireKanunaPhoneBox;
    }

}
