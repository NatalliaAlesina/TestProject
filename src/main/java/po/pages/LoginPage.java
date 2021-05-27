package po.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='form-control']//input[@id='capture_signIn_traditionalSignIn_emailAddress']")
    private WebElement emailAdressFiled;

    @FindBy(xpath = "//div[@class='form-control']//input[@id='capture_signIn_traditionalSignIn_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='EE form-group']//button[@name='submitButton']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='ee-personalized-banner__info']//a[@rel='nofollow']")
    private WebElement loginLink;

    public LoginPage enterEmail(String email) {
        waitForElementVisible(emailAdressFiled);
        emailAdressFiled.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        waitForElementVisible(passwordField);
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage openLoginPage() {
        waitForElementVisible(loginButton);
        loginLink.click();
        return initPage(LoginPage.class);
    }

    public HomePageUpgrade login() {
        loginButton.click();
        return initPage(HomePageUpgrade.class);
    }
}

