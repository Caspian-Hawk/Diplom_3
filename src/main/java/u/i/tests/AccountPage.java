package u.i.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AccountPage {

    private final WebDriver driver;

    private final By buttonExitAccount = By.xpath(".//button[text()='Выход']");
    final By pageAccount = By.className("App_App__aOmNj");

    public AccountPage(WebDriver driver) {
        this.driver = driver;

    }
    @Step("Click button Exit")
    public void clickButtonExitAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(buttonExitAccount));
        driver.findElement(buttonExitAccount).click();
    }
}