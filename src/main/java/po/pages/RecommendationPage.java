package po.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RecommendationPage extends po.pages.BasePage {

    @FindBy (xpath = "//div[@id='recommendPlan']//div[@id='productHeroSection']")
    private WebElement recommendationDeviceBox;

    @FindBy (xpath = "//h1[contains(text(), 'iPhone X')]")
    private WebElement iPhoneXBox;

    public RecommendationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRecommendationDevice() {
        return recommendationDeviceBox;
    }

    public WebElement getiPhoneXBox() {
        return iPhoneXBox;
    }

}

