package UITests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestsDesigner {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Test transition in rolls")
    @Description("Этот тест проверяет в Конструкторе бургеров переход в раздел Булки")
    public void TestTransitionInRolls() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        MainPage.clickButtonSauces();

        MainPage.clickButtonRolls();
    }

    @Test
    @DisplayName("Test transition in sauces")
    @Description("Этот тест проверяет в Конструкторе бургеров переход в раздел Соусы")
    public void TestTransitionInSauces() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        MainPage.clickButtonSauces();
    }

    @Test
    @DisplayName("Test transition in filling")
    @Description("Этот тест проверяет в Конструкторе бургеров переход в раздел Начинки")
    public void TestTransitionInFilling() throws InterruptedException {

        WebDriver driver = driverRule.getDriver();

        var MainPage = new MainPage(driver);

        // открыть сайт
        MainPage.openMainPage();

        MainPage.clickButtonFilling();
    }
}