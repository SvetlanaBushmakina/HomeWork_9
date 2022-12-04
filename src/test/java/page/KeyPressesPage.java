package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class KeyPressesPage {
    private final static SelenideElement inputWindow = $x("//input");
    public static SelenideElement checkedText;

    public static void setTextOnInput(String text) {
        inputWindow.sendKeys(text);
        checkedText = $(byText("You entered: " + text.toUpperCase()));
    }
}
