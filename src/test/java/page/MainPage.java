package page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static void clickTextOnMainPage(String text) {
        $(byText(text)).click();
    }

    public static void openWebSite(String url) {
        Selenide.open(url);
    }

}
