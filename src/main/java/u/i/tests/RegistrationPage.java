package u.i.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;
    private final UserData userData; // Добавляем объект UserData
    private final By fieldEmailRegistrationForm = By.xpath(".//fieldset[2]//input[@class='text input__textfield text_type_main-default'][@name='name']");
    private final By fieldPasswordRegistrationForm = By.xpath(".//fieldset[3]//input[@class='text input__textfield text_type_main-default'][@name='Пароль']");
    private final By fieldNameRegistrationForm = By.xpath(".//fieldset[1]//input[@class='text input__textfield text_type_main-default'][@name='name']");
    private final By buttonRegistration = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By buttonInter = By.className("Auth_link__1fOlj");

    public RegistrationPage(WebDriver driver, UserData userData) {
        this.driver = driver;
        this.userData = userData; // Инициализируем userData
    }

    @Step("Input Email")
    public void inputFieldEmailRegistrationForm() {
        driver.findElement(fieldEmailRegistrationForm).sendKeys(userData.getEmail());
    }

    @Step("Input Password")
    public void inputFieldPasswordRegistrationForm() {
        driver.findElement(fieldPasswordRegistrationForm).sendKeys(userData.getPassword());
    }

    @Step("Input Name")
    public void inputFieldNameRegistrationForm() {
        driver.findElement(fieldNameRegistrationForm).sendKeys(userData.getName());
    }

    @Step("Click button Registration")
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Click button Inter")
    public void clickButtonInter() {
        driver.findElement(buttonInter).click();
    }
}