package po.pages;

import utils.DriverUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageUpgrade extends po.pages.BasePage {

    @FindBy(xpath = "//a[contains(text(),'See Upgrade Options')]")
    private WebElement seeUpgradeOptionsButton;
    @FindBy(xpath = "//form[@id='command']//input[@value='CHOOSE THIS PLAN']")
    private WebElement choosePlanButton;

    public HomePageUpgrade openAuthMenu() {
        DriverUtils.moveToElement(myShopButton);
        waitForElementVisible(allPhonesButton);
        return initPage(HomePageUpgrade.class);
    }

    public GalleryPage openAuthGalleryPage() {
        allPhonesButton.click();
        waitForElementVisible(seeUpgradeOptionsButton);
        return initPage(GalleryPage.class);
    }

    public RecommendationPage openRecommendationPage() {
        seeUpgradeOptionsButton.click();
        waitForElementVisible(choosePlanButton);
        return initPage(RecommendationPage.class);
    }

    public WebElement getSeeUpgradeOptionsButton() {
        return seeUpgradeOptionsButton;
    }

}

