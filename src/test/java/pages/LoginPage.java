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

    public void open() {
        Selenide.open("https://the-internet.herokuapp.com/");
        $$("a").findBy(Condition.text("Form Authentication")).click();
    }

    public void typeUsername(String username) {
        usernameField.setValue(username);
    }

    public void typePassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void verifyLoginPageTitle() {
        $("h2").shouldHave(Condition.text("Login Page"));
    }

    public void verifySuccessMessage(String expectedText) {
        flashMessage.shouldHave(Condition.text(expectedText));
    }

    public void verifyLogoutButtonPresent() {
        logoutButton.shouldHave(Condition.text("Logout"));
    }

    public void verifyElementalSeleniumLinkPresent() {
        $("#page-footer").shouldHave(Condition.text("Elemental Selenium"));
    }
}