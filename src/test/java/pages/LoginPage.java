package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("button[type=submit]");
    private final SelenideElement flashMessage = $("#flash");
    private final SelenideElement logoutButton = $("a.button");

    public LoginPage open() {
        Selenide.open("https://the-internet.herokuapp.com/");
        $$("a").findBy(Condition.text("Form Authentication")).click();
        return this;
    }

    public LoginPage typeUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    public LoginPage clickLogout() {
        logoutButton.click();
        return this;
    }

    public LoginPage verifyLoginPageTitle() {
        $("h2").shouldHave(Condition.text("Login Page"));
        return this;
    }

    public LoginPage verifySuccessMessage(String expectedText) {
        flashMessage.shouldHave(Condition.text(expectedText));
        return this;
    }

    public void verifyErrorMessage(String expectedText) {
        flashMessage.shouldHave(Condition.text(expectedText));
    }

    public LoginPage verifyLogoutButtonPresent() {
        logoutButton.shouldHave(Condition.text("Logout"));
        return this;
    }

    public LoginPage verifyElementalSeleniumLinkPresent() {
        $("#page-footer").shouldHave(Condition.text("Elemental Selenium"));
        return this;
    }
}