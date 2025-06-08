package u.i.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class TestTransitionPersonalAccount {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Test transition in personal account")
    @Description("Этот тест проверяет переход в Личный кабинет")
    public void TestTransitionInPersonalAccount() throws InterruptedException {
        WebDriver driver = driverRule.getDriver();
        UserData userData = driverRule.getUserData();

        var MainPage = new MainPage(driver);
        var AccountPage = new AccountPage(driver);
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

        assertTrue(driver.findElement(AccountPage.pageAccount).isDisplayed());
    }
}