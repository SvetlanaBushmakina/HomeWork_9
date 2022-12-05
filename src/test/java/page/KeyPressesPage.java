package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class KeyPressesPage {
    public final static SelenideElement inputWindow = $x("//input");
    public static SelenideElement checkedText;

    public static void setTextOnInput(String text) {
        inputWindow.sendKeys(text);
        checkedText = $(byText("You entered: " + text.toUpperCase()));
    }
    public static void setSpecialTextOnInput(String specialKey){
        inputWindow.sendKeys(Keys.valueOf(specialKey));
        checkedText = $(byText("You entered: " + specialKey));
    }
}
