package u.i.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class TestsRegistration {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Test successful registration")
    @Description("Этот тест проверяет возможность регистрации")
    public void TestSuccessfulRegistration() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();
        UserData userData = driverRule.getUserData();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver, userData);
        var RegistrationPage = new RegistrationPage(driver, userData);
        var AccountPage = new AccountPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        // кнопка Войти в аккаунт
        MainPage.clickButtonInterAccount();

        // Вы новый пользователь? Зарегистрироваться
        InterPage.clickLinkRegistration();

        // форма регистрации поле Имя
        RegistrationPage.inputFieldNameRegistrationForm();
        // поле email
        RegistrationPage.inputFieldEmailRegistrationForm();
        // поле пароль
        RegistrationPage.inputFieldPasswordRegistrationForm();
        // кнопка Зарегистрироваться
        RegistrationPage.clickButtonRegistration();

        MainPage.clickBarPersonalAccount();

        // форма входа поле email
        InterPage.completionFieldEmailInterForm();
        // форма входа поле Пароль
        InterPage.inputSixCharactersPasswordInterForm();

        // форма входа кнопка Войти
        InterPage.clickButtonInterInterForm();

        // успешная регистрация, возврат на главную страницу, вход в Личный кабинет
        MainPage.clickBarPersonalAccount();

        assertTrue(driver.findElement(AccountPage.pageAccount).isDisplayed());
    }

    @Test
    @DisplayName("Test error message less six characters password")
    @Description("Этот тест проверяет вывод ошибки, если пароль меньше шести символов")
    public void TestErrorMessageLessSixCharactersPassword() throws InterruptedException {
        WebDriver driver = driverRule.getDriver();
        UserData userData = driverRule.getUserData();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver, userData);
        var RegistrationPage = new RegistrationPage(driver, userData);

        // открыть сайт
        MainPage.openMainPage();

        // кнопка Войти в аккаунт
        MainPage.clickButtonInterAccount();

        // Вы новый пользователь? Зарегистрироваться
        InterPage.clickLinkRegistration();

        // форма регистрации поле Имя
        RegistrationPage.inputFieldNameRegistrationForm();
        // поле email
        RegistrationPage.inputFieldEmailRegistrationForm();
        // поле пароль
        InterPage.inputThreeCharactersFieldPasswordInterForm();

        // кнопка Зарегистрироваться
        RegistrationPage.clickButtonRegistration();

        // высветилось сообщение об ошибке "Некорректный пароль"
        assertTrue(driver.findElement(InterPage.errorWrongPasswordInterForm).isDisplayed());
    }

    @Test
    @DisplayName("Test minimum password six characters")
    @Description("Этот тест проверяет минимальное количество символов в поле Пароль")
    public void TestMinimumPasswordSixCharacters() throws InterruptedException {
        WebDriver driver = driverRule.getDriver();
        UserData userData = driverRule.getUserData();

        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver, userData);
        var RegistrationPage = new RegistrationPage(driver, userData);
        var AccountPage = new AccountPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        // кнопка Войти в аккаунт
        MainPage.clickButtonInterAccount();

        // Вы новый пользователь? Зарегистрироваться
        InterPage.clickLinkRegistration();

        // форма регистрации поле Имя
        RegistrationPage.inputFieldNameRegistrationForm();
        // поле email
        RegistrationPage.inputFieldEmailRegistrationForm();
        // поле пароль
        RegistrationPage.inputFieldPasswordRegistrationForm();
        // кнопка Зарегистрироваться
        RegistrationPage.clickButtonRegistration();

        MainPage.clickBarPersonalAccount();

        // форма входа поле email
        InterPage.completionFieldEmailInterForm();
        // форма входа поле Пароль
        InterPage.inputSixCharactersPasswordInterForm();

        // форма входа кнопка Войти
        InterPage.clickButtonInterInterForm();

        // успешная регистрация, возврат на главную страницу, вход Личный кабинет
        MainPage.clickBarPersonalAccount();

        assertTrue(driver.findElement(AccountPage.pageAccount).isDisplayed());
    }
}