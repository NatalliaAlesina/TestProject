package tests;

import base.BaseTest;
import business.objects.user.User;
import business.objects.user.UserFactory;
import po.pages.HomePageUpgrade;
import po.pages.LoginPage;
import po.pages.RecommendationPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EELoginRecommendationTest extends BaseTest {

    @Test(enabled = false, description = "Login")
    public void checkLogin() {
        UserFactory.getUser();
        User user = new User();
        String email = user.getEmail();
        String password = user.getPassword();
        HomePageUpgrade homePage = new LoginPage().openLoginPage().enterEmail(email).enterPassword(password).login();
        Assert.assertTrue(homePage.getSeeUpgradeOptionsButton().isDisplayed(), "Login is not performed");
    }

    @Test(enabled = false, description = "Open Recommendation", dependsOnMethods = { "checkLogin" })
    public void checkRecommendation() {
        RecommendationPage recommendation = new HomePageUpgrade().openRecommendationPage();
        Assert.assertTrue(recommendation.getRecommendationDevice().isDisplayed(), "Recommendation Page is not displayed");
        Assert.assertTrue(recommendation.getiPhoneXBox().isDisplayed(), "Invalid Recommendation Device");
    }

}

