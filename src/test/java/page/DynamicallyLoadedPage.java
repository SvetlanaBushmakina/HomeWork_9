package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicallyLoadedPage {
    public final static SelenideElement example2 = $(byText("Example 2: Element rendered after the fact"));
    public final static SelenideElement buttonStart = $x("//button");
    public final static SelenideElement textAfterLoading = $(byText("Hello World!"));

    public static void clickExample2() {
        example2.click();
    }

    public static void start() {
        buttonStart.click();
    }
}
