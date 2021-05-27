package po.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtrassPage extends BasePage {

    @FindBy(xpath = "//nav[@class='checkout-navigation  ']//span[contains(text(), 'Extras')]")
    private WebElement extrassNavigation;

    @FindBy(xpath = "//main[@id='main']//div[@class='ee-retained-addons']")
    private WebElement retainedDiscountBox;

    @FindBy(xpath = "//table[@class='pay-table pay-monthly-table']//tr[@class='retained-discount ee-discount-row ']")
    private WebElement retainedDiscountStickyBox;

    @FindBy(xpath = "//a[@data-add-on-code='YDC3I7']//span[@class='ee-icon-plus ee-icon-plus__insurance']")
    private WebElement selectInsuranceButton;

    @FindBy(css = "input.aqua.button.focusLoopLast.choose-addon-button")
    private WebElement addButton;

    @FindBy(xpath = "//tr[@class='summary-addon ee-discount-row']//span[@id='fresh-addon-price-table-info-0']")
    public WebElement insuranceStickyBox;

    @FindBy(css = "span.draw_header_text.openDraw.state")
    private WebElement capAddonBox;

    @FindBy(xpath = "//div[@class='form__check form__check--inline form__check--caps']//label[@for='YCAP4000-1']")
    private WebElement capValue;

    @FindBy(xpath = "//div[@class='col addon__added_to_basket EE addon__subheader--cap  hide']")
    private WebElement capAddonResult;

    public ExtrassPage selectInsurance() {
        waitForElementVisible(selectInsuranceButton);
        selectInsuranceButton.click();
        addButton.click();
        return this;
    }

    public ExtrassPage openCap() {
        waitForElementVisible(capAddonBox);
        capAddonBox.click();
        return this;
    }

    public ExtrassPage selectCap() {
        waitForElementVisible(capValue);
        capValue.click();
        waitForElementVisible(capAddonResult);
        return this;
    }

    public WebElement getExtrassNavigation() {
        return extrassNavigation;
    }

    public WebElement getRetainedDiscount() {
        return retainedDiscountBox;
    }

    public WebElement getRetainedDiscountSticky() {
        return retainedDiscountStickyBox;
    }

    public WebElement getInsuranceSticky() {
        return insuranceStickyBox;
    }

    public WebElement getCapAddonResult() {
        return capAddonResult;
    }

}

