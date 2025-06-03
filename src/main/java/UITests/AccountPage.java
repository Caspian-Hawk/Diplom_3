package UITests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class AccountPage {

    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;

    }
    @Step
    public void clickButtonExitAccount() {
        By buttonExitAccount = By.xpath(".//button[text()='Выход']");
        driver.findElement(buttonExitAccount).click();
    }

    @Step
    public void accountPageIsDisplayed() {
        assertTrue(driver.findElement(By.className("App_App__aOmNj")).isDisplayed());
    }

    @Step
    public void listIsDisplayed() {
        assertTrue(driver.findElement(By.className("Account_nav__Lgali")).isDisplayed());
    }
}