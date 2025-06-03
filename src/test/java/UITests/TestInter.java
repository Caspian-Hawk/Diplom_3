package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestInter {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Test inter in button inter account")
    @Description("Этот тест проверяет возможность входа в аккаунт через кнопку Войти в аккаунт")
    public void TestInterInButtonInterAccount() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver);
        var AccountPage = new AccountPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        // кнопка Войти в аккаунт
        MainPage.clickButtonInterAccount();

        // форма входа поле email
        InterPage.completionFieldEmailInterForm();
        // форма входа поле Пароль
        InterPage.inputSixCharactersPasswordInterForm();

        // форма входа кнопка Войти
        InterPage.clickButtonInterInterForm();
        Thread.sleep(1000);

        // вход в Личный кабинет
        MainPage.clickBarPersonalAccount();

        AccountPage.accountPageIsDisplayed();
    }

    @Test
    @DisplayName("Test inter in button bar personal account")
    @Description("Этот тест проверяет возможность входа в аккаунт через кнопку Личный кабинет")
    public void TestInterInButtonBarPersonalAccount() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver);
        var AccountPage = new AccountPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        // вход в Личный кабинет
        MainPage.clickBarPersonalAccount();

        // форма входа поле email
        InterPage.completionFieldEmailInterForm();
        // форма входа поле Пароль
        InterPage.inputSixCharactersPasswordInterForm();

        // форма входа кнопка Войти
        InterPage.clickButtonInterInterForm();

        AccountPage.accountPageIsDisplayed();
    }

    @Test
    @DisplayName("Test inter in registration form")
    @Description("Этот тест проверяет возможность входа в аккаунт через форму регистрации")
    public void TestInterInRegistrationForm() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver);
        var AccountPage = new AccountPage(driver);
        var RegistrationPage = new RegistrationPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        // кнопка Войти в аккаунт
        MainPage.clickButtonInterAccount();

        // Вы новый пользователь? Зарегистрироваться
        InterPage.clickLinkRegistration();

        RegistrationPage.clickButtonInter();

        // форма входа поле email
        InterPage.completionFieldEmailInterForm();
        // форма входа поле Пароль
        InterPage.inputSixCharactersPasswordInterForm();

        // форма входа кнопка Войти
        InterPage.clickButtonInterInterForm();
        Thread.sleep(1000);

        // вход в Личный кабинет
        MainPage.clickBarPersonalAccount();

        AccountPage.accountPageIsDisplayed();
    }

    @Test
    @DisplayName("Test inter in link password recover")
    @Description("Этот тест проверяет возможность входа в аккаунт через кнопку в форме восстановления пароля")
    public void TestInterInLinkPasswordRecover() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver);
        var AccountPage = new AccountPage(driver);
        var RecoverPasswordPage = new RecoverPasswordPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        // вход в Личный кабинет
        MainPage.clickBarPersonalAccount();

        InterPage.clickLinkPasswordRecovery();

        RecoverPasswordPage.clickButtonInterRecoverPasswordForm();

        // форма входа поле email
        InterPage.completionFieldEmailInterForm();
        // форма входа поле Пароль
        InterPage.inputSixCharactersPasswordInterForm();

        // форма входа кнопка Войти
        InterPage.clickButtonInterInterForm();
        Thread.sleep(1000);

        // вход в Личный кабинет
        MainPage.clickBarPersonalAccount();

        AccountPage.accountPageIsDisplayed();
    }
}