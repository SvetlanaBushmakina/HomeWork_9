package testSteps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.ca.I;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import page.*;

import java.time.Duration;

public class InternetHerokuappSteps {
    public final static String baseUrl = "https://the-internet.herokuapp.com/";
    int count;

    @Дано("^Открываем https://the-internet\\.herokuapp\\.com/$")
    public void openMainPage() {
        MainPage.openWebSite(baseUrl);
        System.out.println("Открываем веб сайт: " + baseUrl);
    }

    @Дано("^Нажать на '(.+)'$")
    public void click(String text) {
        MainPage.clickTextOnMainPage(text);
        System.out.println("Нажимаем на " + text);
    }


    @И("^Нажать на checkbox1$")
    public void setCheckbox1() {
        CheckboxesPage.setCheckbox1();
        System.out.println("Ставим галочку на checkbox 1");
    }

    @Тогда("^Проверить, что checkbox1 нажат$")
    public void checkSetCheckbox1() {
        CheckboxesPage.checkbox1.shouldBe(Condition.selected);
        System.out.println("checkbox 1 нажат");
    }

    @Когда("^Ввести верные логин '(.+)' и пароль '(.+)' и нажать на Login$")
    public void enterTheUsernameAndPassword(String username, String password) {
        FormAuthenticationPage.enterUsernameAndPassword(username, password);
        System.out.println("Вводим логин и пароль и нажимаем Login ");

    }

    @Тогда("^Проверить сообщение об успешном входе$")
    public void checkTextSuccessfulАuthorization() {
        FormAuthenticationPage.successfulАuthorization.shouldBe(Condition.visible);
        System.out.println("Логин и пароль введены верно");
    }

    @Когда("^Ввести неверные логин '(.+)' и пароль '(.+)' и нажать на Login$")
    public void enterTheUsernameAndPasswordInvalid(String usernameInvalid, String passwordInvalid) {
        FormAuthenticationPage.enterUsernameAndPassword(usernameInvalid, passwordInvalid);
        System.out.println("Вводим неверные логин и пароль и нажимаем Login ");
    }

    @Тогда("^Проверить сообщение об ошибке$")
    public void checkTextUnSuccessfulАuthorization() {
        FormAuthenticationPage.unSuccessfulАuthorization.shouldBe(Condition.visible);
        System.out.println("Логин и пароль введены неверно");
    }

    @Когда("^Навести на (\\d+) пользователя$")
    public void pointingToAnElement(Integer index) {
        HoverPage.pointingToAnElement(index);
        System.out.println("Выбран элемент");
    }

    @Тогда("^Проверить, что отображается текст$")
    public void checkPointingToAnElement() {
        HoverPage.text.shouldBe(Condition.visible);
        System.out.println("Текст элемента виден");
    }

    @Когда("^Нажать на Example2$")
    public void clickExample2() {
        DynamicallyLoadedPage.clickExample2();
        System.out.println("Нажимаем на Example 2");
    }

    @И("^Нажать на кнопку Start$")
    public void clickStart() {
        DynamicallyLoadedPage.start();
        System.out.println("Нажимаем на кнопку Start");
    }

    @Тогда("^Проверить текст после Loading$")
    public void checkTextAfterLoading() {
        DynamicallyLoadedPage.textAfterLoading.shouldBe(Condition.visible, Duration.ofSeconds(10));
        System.out.println("Отображается текст Hello World!");
    }

    @Когда("^Ввести клавишу '(.+)' в поле ввода$")
    public void enterKeyInInputField(String text) {
        KeyPressesPage.setTextOnInput(text);
        System.out.println("Вводим текст в поле ввода");
    }

    @Тогда("^Проверить, что клавиша '(.+)' отображается в You entered$")
    public void checkEnterKeyInInputField(String text) {
        KeyPressesPage.checkedText.shouldBe(Condition.visible);
        System.out.println("You entered: " + text.toUpperCase());
    }

    @Когда("^Добавить (\\d+) элемента$")
    public void addElement(int countClick) {
        count = countClick;
        AddRemoveElements.clickAddElement(countClick);
        System.out.println("Нажали на кнопку Add Element");
    }

    @Тогда("^Проверить, что отображаются добавленные элементы$")
    public void checkAddElements() {
        Assert.assertEquals(count, AddRemoveElements.buttonDelete.size());
        for (int i = 0; i < AddRemoveElements.buttonDelete.size(); i++) {
            AddRemoveElements.buttonDelete.get(i).shouldBe(Condition.visible);
        }
        System.out.println("Delete отображается " + count + " раз");
    }
}
