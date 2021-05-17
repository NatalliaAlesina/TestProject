package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.CustomDriver;
import po.pages.GalleryPage;
import po.pages.HomePage;
import po.pages.PdpPage;

public class EEUnauthTest extends BaseTest {

    @Test(groups = {"Smoke", "Full"}, description = "Check Shop button and Pay monthly phones menu item displaying")
    public void checkShopAndPaymMonthlyPhonesDisp() {
        HomePage menu = new HomePage(CustomDriver.getWebDriverInstance()).openMenu();
        Assert.assertTrue(menu.getShopButton().isDisplayed(), "No required Shop menu on the page!");
        Assert.assertTrue(menu.getPhonesButton().isDisplayed(), "No required Pay monthly phones menu item on the page!");
    }

    @Test(groups = {"Full"}, description = "Check filter result")
    public void checkFilterResult() {
        new HomePage (CustomDriver.getWebDriverInstance()).openMenu().openGalleryPage();
        GalleryPage filter = new GalleryPage (CustomDriver.getWebDriverInstance()).clickGoogleCheckBox().clickAppleCheckBox();
        Assert.assertTrue(filter.getEEPhone().isDisplayed(), "Filter results are invalid!");
    }


    @Test(groups = {"Smoke", "Full"}, description = "Check Drop Down results")
    public void checkDD() {
        new HomePage (CustomDriver.getWebDriverInstance()).openMenu().openGalleryPage().openPDPPage();
        PdpPage dropDown = new PdpPage (CustomDriver.getWebDriverInstance()).select256GbCapacity();
        System.out.println(dropDown.getUpfrontCost().getText());
        Assert.assertTrue (dropDown.getUpfrontCost().getText().contains("£50"));
    }

    @Test(enabled = false, description = "Check Invalid PostCode", dependsOnMethods = { "checkShopAndPaymMonthlyPhonesDisp" })
    public void checkInvalidPostCode() {
        Assert.assertTrue(new PdpPage (CustomDriver.getWebDriverInstance()).checkPostCode("AL109BW"), "Invalid post Code is accepted");
    }

    @Test(enabled = false, description = "Check Valid PostCode", dependsOnMethods = { "checkShopAndPaymMonthlyPhonesDisp" })
    public void checkValidPostCode() {
        Assert.assertFalse(new PdpPage (CustomDriver.getWebDriverInstance()).checkPostCode("AL109BW"), "Invalid post Code is accepted");
    }

}
