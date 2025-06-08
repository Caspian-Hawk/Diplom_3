package u.i.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class TestsTransitionInDesigner {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Test transition in designer logo")
    @Description("Этот тест проверяет переход в раздел Конструктор через лого")
    public void TestTransitionInDesignerLogo() throws InterruptedException {
        WebDriver driver = driverRule.getDriver();
        UserData userData = driverRule.getUserData();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver, userData);

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

        assertTrue(driver.findElement(MainPage.pageDesigner).isDisplayed());
    }

    @Test
    @DisplayName("Test transition in designer button designer")
    @Description("Этот тест проверяет переход в раздел Конструктор через кнопку Конструктор")
    public void TestTransitionInDesignerButtonDesigner() throws InterruptedException {
        WebDriver driver = driverRule.getDriver();
        UserData userData = driverRule.getUserData();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver, userData);

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

        assertTrue(driver.findElement(MainPage.pageDesigner).isDisplayed());
    }
}