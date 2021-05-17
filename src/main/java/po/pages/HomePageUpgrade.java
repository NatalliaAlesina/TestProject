package po.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.HighlightUtils;


public class HomePageUpgrade extends po.pages.BasePage {

    @FindBy (xpath = "//a[contains(text(),'See Upgrade Options')]")
    private WebElement seeUpgradeOptionsButton;
    @FindBy (xpath = "//form[@id='command']//input[@value='CHOOSE THIS PLAN']")
    private WebElement choosePlanButton;

    public HomePageUpgrade(WebDriver driver) {
        super(driver);
    }

    public HomePageUpgrade openAuthMenu() {
        HighlightUtils.highlightElement(myShopButton);
        moveToElement(myShopButton);
        waitForElementVisible(allPhonesButton);
        return new HomePageUpgrade (driver);
    }

    public po.pages.GalleryPage openAuthGalleryPage() {
        allPhonesButton.click();
        waitForElementVisible(seeUpgradeOptionsButton);
        HighlightUtils.highlightElement(seeUpgradeOptionsButton);
        return new GalleryPage(driver);
    }

    public RecommendationPage openRecommendationPage() {
        seeUpgradeOptionsButton.click();
        waitForElementVisible(choosePlanButton);
        return new RecommendationPage (driver);
    }

    public WebElement getSeeUpgradeOptionsButton() {
        return seeUpgradeOptionsButton;
    }

}

