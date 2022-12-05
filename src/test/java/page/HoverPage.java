package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class HoverPage {
    public static SelenideElement text;
    public final static ElementsCollection usersAvatars = $$x("//img[@alt='User Avatar']");

    public static void pointingToAnElement(Integer index) {
        usersAvatars.get(index).hover();
        Integer user = index + 1;
        text = $(byText("name: user" + user));
    }
}
