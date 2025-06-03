package UITests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private final WebDriver driver;

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By buttonInterRecoverPasswordForm = By.className("Auth_link__1fOlj");
    @Step
    public void clickButtonInterRecoverPasswordForm() {
        driver.findElement(buttonInterRecoverPasswordForm).click();
    }
}