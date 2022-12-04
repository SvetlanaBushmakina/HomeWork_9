package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckboxesPage {
    public final static SelenideElement checkbox1 = $x("//input");

    public static void setCheckbox1() {
        checkbox1.click();
    }
}
