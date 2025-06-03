package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestExitAccount {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Test exit account")
    @Description("Этот тест проверяет возможность входа из аккаунта")
    public void TestExitFromAccount() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();
        var MainPage = new MainPage(driver);
        var InterPage = new InterPage(driver);
        var AccountPage = new AccountPage(driver);

        MainPage.openMainPage();
        MainPage.clickButtonInterAccount();
        InterPage.completionFieldEmailInterForm();
        InterPage.inputSixCharactersPasswordInterForm();
        InterPage.clickButtonInterInterForm();
        MainPage.clickBarPersonalAccount();
        AccountPage.clickButtonExitAccount();
    }
}