import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest {
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void successfulLoginTest() {
        loginPage.open()
                .verifyLoginPageTitle()
                .typeUsername("tomsmith")
                .typePassword("SuperSecretPassword!")
                .clickLogin()
                .verifySuccessMessage("You logged into a secure area!")
                .verifyLogoutButtonPresent()
                .clickLogout()
                .verifyLoginPageTitle();
    }

    @Test
    public void invalidLoginTest() {
        loginPage.open()
                .verifyLoginPageTitle()
                .verifyElementalSeleniumLinkPresent()
                .typeUsername("admin")
                .typePassword("1234")
                .clickLogin()
                .verifyErrorMessage("Your username is invalid!");
    }
}