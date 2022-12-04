package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FormAuthenticationPage {
    private final static SelenideElement username = $x("//input[@id='username']");
    private final static SelenideElement password = $x("//input[@id='password']");
    private final static SelenideElement buttonLogin = $x("//button");
    public final static SelenideElement successfulАuthorization = $(byText("You logged into a secure area!"));
    public final static SelenideElement unSuccessfulАuthorization = $(byText("Your username is invalid!"));


    public static void enterUsernameAndPassword(String login, String pass) {
        username.sendKeys(login);
        password.sendKeys(pass);
        buttonLogin.click();
    }
}
