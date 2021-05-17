package tests;

import base.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import business.objects.user.User;
import business.objects.user.UserFactory;
import driver.CustomDriver;
import po.pages.HomePageUpgrade;
import po.pages.LoginPage;
import po.pages.RecommendationPage;


public class EELoginRecommendationTest extends BaseTest {

    @Test(enabled = false, description = "Login")
    public void checkLogin() {
        UserFactory.getUser();
        User user = new User();
        String email = user.getEmail();
        String password = user.getPassword();
        HomePageUpgrade homePage = new LoginPage (CustomDriver.getWebDriverInstance()).openLoginPage().enterEmail(email).enterPassword(password).login();
        Assert.assertTrue(homePage.getSeeUpgradeOptionsButton().isDisplayed(), "Login is not performed");
    }

    @Test(enabled = false, description = "Open Recommendation", dependsOnMethods = { "checkLogin" })
    public void checkRecommendation() {
        RecommendationPage recommendation = new HomePageUpgrade (CustomDriver.getWebDriverInstance()).openRecommendationPage();
        Assert.assertTrue(recommendation.getRecommendationDevice().isDisplayed(), "Recommendation Page is not displayed");
        Assert.assertTrue(recommendation.getiPhoneXBox().isDisplayed(), "Invalid Recommendation Device");
    }

}

