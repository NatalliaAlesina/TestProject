package tests;

import base.BaseTest;
import business.logic.IFilterService;
import business.logic.IMenuService;
import business.logic.IPdpService;
import po.pages.PdpPage;

import javax.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EEUnauthTest extends BaseTest {

    @Inject
    private IMenuService menuService;

    @Inject
    private IFilterService filterService;

    @Inject
    private IPdpService pdpService;

    @Test(groups = { "Smoke", "Full" }, description = "Check Shop button and Pay monthly phones menu item displaying")
    public void checkShopAndPaymMonthlyPhonesDisp() {
        menuService.openMenu();
        Assert.assertTrue(menuService.isShopButtonDisplayed(), "No required Shop menu on the page!");
        Assert.assertTrue(menuService.isPhoneMenuItemDisplayed(), "No required Pay monthly phones menu item on the page!");
    }

    @Test(groups = { "Full" }, description = "Check filter result")
    public void checkFilterResult() {
        filterService.openGalleryPage();
        filterService.clickGoogleFilter();
        filterService.clickAppleFilter();
        Assert.assertTrue(filterService.isEePhoneDisplayed(), "Filter results are invalid!");
    }

    @Test(groups = { "Smoke", "Full" }, description = "Check Drop Down results")
    public void checkDD() {
        menuService.openMenu();
        pdpService.openPDPPage();
        pdpService.select256GbCapacity();
        Assert.assertTrue(pdpService.getUpfrontCost().contains("£50"));
    }

    @Test(enabled = false, description = "Check Invalid PostCode", dependsOnMethods = { "checkShopAndPaymMonthlyPhonesDisp" })
    public void checkInvalidPostCode() {
        Assert.assertTrue(new PdpPage().checkPostCode("AL109BW"), "Invalid post Code is accepted");
    }

    @Test(enabled = false, description = "Check Valid PostCode", dependsOnMethods = { "checkShopAndPaymMonthlyPhonesDisp" })
    public void checkValidPostCode() {
        Assert.assertFalse(new PdpPage().checkPostCode("AL109BW"), "Invalid post Code is accepted");
    }

}
