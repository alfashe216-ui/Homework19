import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @Test
    public void successfulLoginTest() {
        open("https://the-internet.herokuapp.com/");
        $$("#content ul li a").findBy(Condition.text("Form Authentication")).click();
        $("h2").shouldHave(Condition.text("Login Page"));
        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $("button[type=submit]").click();
        $("#flash").shouldHave(Condition.text("You logged into a secure area!"));
        $("a.button").shouldHave(Condition.text("Logout"));
        $("a.button").click();
        $("h2").shouldHave(Condition.text("Login Page"));
    }

    @Test
    public void invalidLoginTest() {
        open("https://the-internet.herokuapp.com/");
        $$("#content ul li a").findBy(Condition.text("Form Authentication")).click();
        $("h2").shouldHave(Condition.text("Login Page"));
        $("#page-footer").shouldHave(Condition.text("Elemental Selenium"));
        $("#username").setValue("admin");
        $("#password").setValue("1234");
        $("button[type=submit]").click();
        $("#flash").shouldHave(Condition.text("Your username is invalid!"));
    }
}