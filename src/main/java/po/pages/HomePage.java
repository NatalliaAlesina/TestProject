package po.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.CustomDriver;
import utils.HighlightUtils;

public class HomePage extends BasePage {

    @FindBy(xpath = "//iframe[@title='TrustArc Cookie Consent Manager']")
    private WebElement cookiePolicyFrame;

    @FindBy(xpath = "//div[@class='pdynamicbutton']//a[@class='call']")
    private WebElement acceptButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage closeCookieBanner() {
        if (CustomDriver.isDisplayed(cookiePolicyFrame)) {
            driver.switchTo().frame(cookiePolicyFrame);
            waitForElementVisible(acceptButton);
            try {
                HighlightUtils.highlightElement(acceptButton);
                if (acceptButton.isDisplayed()) {
                    acceptButton.click();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (NoSuchElementException t) {

            }
        }
        return new HomePage(driver);
    }

    public HomePage openMenu() {
        HighlightUtils.highlightElement(getShopButton());
        moveToElement(getShopButton());
        waitForElementVisible(getPhonesButton());
        return new HomePage(driver);
    }

    public GalleryPage openGalleryPage() {
        getPhonesButton().click();
        return new GalleryPage(driver);
    }

}

