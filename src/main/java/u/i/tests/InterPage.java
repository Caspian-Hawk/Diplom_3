package u.i.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class InterPage {

    private final WebDriver driver;

    final By buttonInterInterForm = By.xpath(".//button[text()='Войти']");
    private final By fieldEmailInterForm = By.xpath(".//input[@name='name']");
    private final By fieldPasswordInterForm = By.xpath(".//input[@name='Пароль']");
    final By errorWrongPasswordInterForm = By.xpath(".//p[text()='Некорректный пароль']");
    private final By linkRegistration = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']//a[@class='Auth_link__1fOlj']");
    private final By linkPasswordRecovery = By.className("Auth_link__1fOlj");
    private final UserData userData;

    public InterPage(WebDriver driver, UserData userData) {
        this.driver = driver;
        this.userData = userData;
    }

    @Step("Click button Inter in form Inter")
    public void clickButtonInterInterForm() {
        driver.findElement(buttonInterInterForm).click();
    }

    @Step("Input six characters in field Password")
    public void inputSixCharactersPasswordInterForm(String password) {
        driver.findElement(fieldPasswordInterForm).sendKeys(password);
    }

    @Step("Input three characters in field Password")
    public void inputThreeCharactersFieldPasswordInterForm() {
        driver.findElement(fieldPasswordInterForm).sendKeys("654");
    }

    @Step("Input email in field Email")
    public void completionFieldEmailInterForm(String email) {
        driver.findElement(fieldEmailInterForm).sendKeys(email);
    }

    @Step("Click link registration")
    public void clickLinkRegistration() {
        driver.findElement(linkRegistration).click();
    }

    @Step("Click link password recovery")
    public void clickLinkPasswordRecovery() {
        driver.findElement(linkPasswordRecovery).click();
    }
}