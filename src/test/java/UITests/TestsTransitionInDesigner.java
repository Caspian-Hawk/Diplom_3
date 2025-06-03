package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestsTransitionInDesigner {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Test transition in designer logo")
    @Description("Этот тест проверяет переход в раздел Конструктор через лого")
    public void TestTransitionInDesignerLogo() throws InterruptedException {
        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        MainPage.clickBarPersonalAccount();

        // форма входа поле email
        InterPage.completionFieldEmailInterForm();
        // форма входа поле Пароль
        InterPage.inputSixCharactersPasswordInterForm();

        // форма входа кнопка Войти
        InterPage.clickButtonInterInterForm();
        Thread.sleep(1000);

        MainPage.clickBarPersonalAccount();

        MainPage.clickLogo();

        MainPage.displayPageDesigner();
    }

    @Test
    @DisplayName("Test transition in designer button designer")
    @Description("Этот тест проверяет переход в раздел Конструктор через кнопку Конструктор")
    public void TestTransitionInDesignerButtonDesigner() throws InterruptedException {
        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        MainPage.clickBarPersonalAccount();

        // форма входа поле email
        InterPage.completionFieldEmailInterForm();
        // форма входа поле Пароль
        InterPage.inputSixCharactersPasswordInterForm();

        // форма входа кнопка Войти
        InterPage.clickButtonInterInterForm();
        Thread.sleep(1000);

        MainPage.clickBarPersonalAccount();

        MainPage.clickButtonDesigner();

        MainPage.displayPageDesigner();
    }
}