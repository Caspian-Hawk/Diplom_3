package u.i.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class TestExitAccount {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Test exit account")
    @Description("Этот тест проверяет возможность выхода из аккаунта")
    public void TestExitFromAccount() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();
        UserData userData = driverRule.getUserData(); // Получаем userData здесь
        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver, userData);
        var AccountPage = new AccountPage(driver);

        MainPage.openMainPage();
        MainPage.clickButtonInterAccount();
        InterPage.completionFieldEmailInterForm(); // Здесь предполагается, что этот метод использует userData
        InterPage.inputSixCharactersPasswordInterForm();
        InterPage.clickButtonInterInterForm();
        MainPage.clickBarPersonalAccount();
        AccountPage.clickButtonExitAccount();
        assertTrue(driver.findElement(MainPage.pageDesigner).isDisplayed());
    }
}