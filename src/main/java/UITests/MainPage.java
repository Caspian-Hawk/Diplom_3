package UITests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainPage {

    private final WebDriver driver;

    private final By buttonBarPersonalAccount = By.xpath(".//a[@href='/account']");
    private final By buttonInterAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By pageDesigner = By.className("App_App__aOmNj");
    private final By buttonDesigner = By.xpath(".//a[@class='AppHeader_header__link__3D_hX'][@href='/']");
    private final By buttonRolls = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[1][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    private final By buttonSauces  = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[2][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    private final By buttonFilling = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[3][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step
    public void clickBarPersonalAccount() {
//        new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.invisibilityOfElementLocated(By.className("Modal_modal_overlay__x2ZCr")));
        driver.findElement(buttonBarPersonalAccount).click();
    }
    @Step
    public void clickLogo() {
        driver.findElement(logo).click();
    }
    @Step
    public void clickButtonDesigner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonDesigner));
        driver.findElement(buttonDesigner).click();
    }
    @Step
    public void clickButtonInterAccount() {
        driver.findElement(buttonInterAccount).click();
    }
    @Step
    public void clickButtonRolls() {
        driver.findElement(buttonRolls).click();
    }
    @Step
    public void clickButtonSauces() {
        driver.findElement(buttonSauces).click();
    }
    @Step
    public void clickButtonFilling() {
        driver.findElement(buttonFilling).click();
    }
    @Step
    public void displayPageDesigner() {
        assertTrue(driver.findElement(pageDesigner).isDisplayed());
    }
    @Step
    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
}