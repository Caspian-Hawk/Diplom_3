package u.i.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {

    private final WebDriver driver;

    private final By buttonInterRecoverPasswordForm = By.className("Auth_link__1fOlj");

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click button Inter recover password form")
    public void clickButtonInterRecoverPasswordForm() {
        driver.findElement(buttonInterRecoverPasswordForm).click();
    }
}