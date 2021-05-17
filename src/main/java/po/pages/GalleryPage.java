package po.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.HighlightUtils;
import utils.ScrollUtils;
public class GalleryPage extends po.pages.BasePage {

    @FindBy (xpath = "//div[@class='hide-md test-filters']//label[@title='Apple']")
    public WebElement appleCheckBox;

    @FindBy (xpath = "//div[@class='col-lg-4 col-md-6 col-xs-12 margin-bottom-1']//h3[contains(text(), 'iPhone 11 Pro - Good As New')]")
    public WebElement iPhone11ProGoodAsNew;

    @FindBy (xpath = "//ul[@id='show']//a[@href='/auth/mobile-phones/upg-pay-monthly/iphone-xr-64gb-white/details']")
    public WebElement iPhoneXRAuthBox;

    @FindBy (xpath = "//div[@class='hide-md test-filters']//label[@title='Google']")
    public WebElement googleCheckBox;

    @FindBy (xpath = "//div[@class='col-lg-4 col-md-6 col-xs-12 margin-bottom-1']//h3[contains(text(), 'Google Pixel 4a with 5G')]")
    public WebElement pixel4aWith5g;

    public GalleryPage (WebDriver driver) {
        super(driver);
    }

    public GalleryPage clickGoogleCheckBox() {

        ScrollUtils.scroolPage(googleCheckBox);
        HighlightUtils.highlightElement(googleCheckBox);

        if (!googleCheckBox.isSelected()) {
            googleCheckBox.click();
        }
        waitForElementVisible(pixel4aWith5g);
        HighlightUtils.highlightElement(pixel4aWith5g);
        return this;
    }

    public GalleryPage clickAppleCheckBox() {

        ScrollUtils.scroolPage(appleCheckBox);
        HighlightUtils.highlightElement(appleCheckBox);

        if (!appleCheckBox.isSelected()) {
            appleCheckBox.click();
        }

        waitForElementVisible(iPhone11ProGoodAsNew);
        HighlightUtils.highlightElement(iPhone11ProGoodAsNew);
        return this;
    }

    public WebElement getEEPhone() {
        return pixel4aWith5g;
    }

    public PdpPage openPDPPage() {
        clickAppleCheckBox();
        iPhone11ProGoodAsNew.click();
        return new PdpPage (driver);
    }

    public PdpPage openPDPAuthPage() {
        iPhoneXRAuthBox.click();
        return new PdpPage (driver);
    }
}
