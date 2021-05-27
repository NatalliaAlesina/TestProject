package tests;

import base.BaseTest;
import business.objects.user.User;
import business.objects.user.UserFactory;
import po.pages.ExtrassPage;
import po.pages.HomePageUpgrade;
import po.pages.LoginPage;
import po.pages.PdpPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EEExtrassTest extends BaseTest {

    @Test(enabled = false, description = "Open Extrass")
    public void checkExtrassOpen() {
        UserFactory.getUser();
        User user = new User();
        String email = user.getEmail();
        String password = user.getPassword();
        new LoginPage().openLoginPage().enterEmail(email).enterPassword(password).login();
        new HomePageUpgrade().openAuthGalleryPage().openPDPAuthPage();
        ExtrassPage exrass = new PdpPage().openExtrass();

        Assert.assertTrue(exrass.getExtrassNavigation().isDisplayed(), "Extrass page is not displayed");
    }

    @Test(enabled = false, description = "Check Extrass", dependsOnMethods = { "checkExtrassOpen" })
    public void checkExtrassPage() {
        ExtrassPage extrassComponents = new ExtrassPage().selectInsurance().openCap().selectCap();
        Assert.assertTrue(extrassComponents.getRetainedDiscount().isDisplayed(), "Retained discount cart is not displayed");
        Assert.assertTrue(extrassComponents.getRetainedDiscountSticky().isDisplayed(), "Retained discount is not displayed in sticky basket");
        Assert.assertTrue(extrassComponents.getInsuranceSticky().isDisplayed(), "Insurance is not displayed in sticky basket");
        Assert.assertTrue(extrassComponents.getCapAddonResult().isDisplayed(), "Cap addon is not added");

    }

}
