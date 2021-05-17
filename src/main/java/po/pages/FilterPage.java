package po.pages;

import business.objects.phone.Brand;
import business.objects.phone.Capacity;
import business.objects.phone.Cost;
import utils.HighlightUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends BasePage {

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-xs-12 margin-bottom-1']//h3[contains(text(), 'HUAWEI P30 lite New Edition - Good As New')]")
    private static WebElement huaweiP30LiteGAN;

    @FindBy(xpath = "//iframe[@title='TrustArc Cookie Consent Manager']")
    private WebElement cookiePolicyFrame;

    @FindBy(xpath = "//div[@class='pdynamicbutton']//a[@class='call']")
    private WebElement acceptButton;

    public FilterPage open() {
        driver.get("https://shop.ee.co.uk/mobile-phones/pay-monthly/gallery?search=:best-sellers");
        return this;
    }

    public static final String SEARCH_XPATH = "//div[@class='hide-md test-filters']//label[@title='%s']";

    public FilterPage selectCost(Cost range) {
        driver.findElement(By.xpath(String.format(SEARCH_XPATH, range.getCostLinkText()))).click();
        return this;
    }

    public FilterPage selectBrand(Brand name) {
        driver.findElement(By.xpath(String.format(SEARCH_XPATH, name.getBrandLinkText()))).click();
        return this;
    }

    public FilterPage selectCapacity(Capacity capacity) {
        driver.findElement(By.xpath(String.format(SEARCH_XPATH, capacity.getCapacityLinkText()))).click();
        return this;
    }

    public static WebElement getHuaweiP30LiteGAN() {
        return huaweiP30LiteGAN;
    }

    public FilterPage closeCookieBanner() {
        if (isDisplayed(cookiePolicyFrame)) {
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
            return new FilterPage(driver);
        }
        else return this;
    }
}
