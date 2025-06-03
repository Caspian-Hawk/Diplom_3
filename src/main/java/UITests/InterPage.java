package UITests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class InterPage {

    private final WebDriver driver;

    final By buttonInterInterForm = By.xpath(".//button[text()='Войти']");
    private final By fieldEmailInterForm = By.xpath(".//input[@name='name']");
    private final By fieldPasswordInterForm = By.xpath(".//input[@name='Пароль']");
    private final By errorWrongPasswordInterForm = By.xpath(".//p[text()='Некорректный пароль']");
    private final By linkRegistration = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']//a[@class='Auth_link__1fOlj']");
    private final By linkPasswordRecovery = By.className("Auth_link__1fOlj");

    public InterPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step
    public void clickButtonInterInterForm() {
        driver.findElement(buttonInterInterForm).click();
    }
    @Step
    public void inputSixCharactersPasswordInterForm() {
        driver.findElement(fieldPasswordInterForm).sendKeys("654321");
    }
    @Step
    public void inputWrongPasswordInterForm() {
        driver.findElement(fieldPasswordInterForm).sendKeys("654bn321");
    }
    @Step
    public void displayErrorWrongPasswordInterForm() {
        driver.findElement(errorWrongPasswordInterForm).isDisplayed();
    }
    @Step
    public void inputThreeCharactersFieldPasswordInterForm() {
        driver.findElement(fieldPasswordInterForm).sendKeys("654");
    }
    @Step
    public void completionFieldEmailInterForm() {
        driver.findElement(fieldEmailInterForm).sendKeys("ivan.karasev@mail.com");
    }
    @Step
    public void clickLinkRegistration() {
        driver.findElement(linkRegistration).click();
    }
    @Step
    public void clickLinkPasswordRecovery() {
        driver.findElement(linkPasswordRecovery).click();
    }
}