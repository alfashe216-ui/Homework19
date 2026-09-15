package stepdefs;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.LoginPage;

public class StepDefinitions {
    private final LoginPage loginPage = new LoginPage();

    @Дано("открыта страница логина")
    public void openLoginPage() {
        loginPage.open();
    }

    @Тогда("заголовок страницы содержит Login Page")
    public void verifyLoginPageTitle() {
        loginPage.verifyLoginPageTitle();
    }

    @Когда("введен логин {string}")
    public void enterUsername(String username) {
        loginPage.typeUsername(username);
    }

    @Когда("введен пароль {string}")
    public void enterPassword(String password) {
        loginPage.typePassword(password);
    }

    @Когда("нажата кнопка Login")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Тогда("сообщение содержит {string}")
    public void verifyMessage(String message) {
        loginPage.verifySuccessMessage(message);
    }

    @Тогда("присутствует кнопка Logout")
    public void verifyLogoutButton() {
        loginPage.verifyLogoutButtonPresent();
    }

    @Когда("нажата кнопка Logout")
    public void clickLogout() {
        loginPage.clickLogout();
    }

    @Тогда("внизу страницы есть ссылка Elemental Selenium")
    public void verifyElementalSeleniumLink() {
        loginPage.verifyElementalSeleniumLinkPresent();
    }
}