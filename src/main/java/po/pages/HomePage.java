package po.pages;

import utils.DriverUtils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//iframe[@title='TrustArc Cookie Consent Manager']")
    private WebElement cookiePolicyFrame;

    @FindBy(xpath = "//div[@class='pdynamicbutton']//a[@class='call']")
    private WebElement acceptButton;

    public HomePage closeCookieBanner() {
        HomePage homePage = initPage(HomePage.class);
        if (homePage.isDisplayed(cookiePolicyFrame)) {
            driver.get().switchTo().frame(cookiePolicyFrame);
            waitForElementVisible(acceptButton);
            try {
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
        return initPage(HomePage.class);
    }

    public HomePage openMenu() {
        DriverUtils.moveToElement(getShopButton());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForElementVisible(getPhonesButton());
        return initPage(HomePage.class);
    }

    public GalleryPage openGalleryPage() {
        getPhonesButton().click();
        DriverUtils.waitForPageLoad();
        return initPage(GalleryPage.class);
    }

}

