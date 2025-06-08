package u.i.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static u.i.tests.Constant.MAIN_PAGE;

public class MainPage {

    private final WebDriver driver;

    private final By buttonBarPersonalAccount = By.xpath(".//a[@href='/account']");
    private final By buttonInterAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    final By pageDesigner = By.className("App_App__aOmNj");
    private final By buttonDesigner = By.xpath(".//a[@class='AppHeader_header__link__3D_hX'][@href='/']");
    private final By buttonRolls = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[1][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    private final By buttonSauces  = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[2][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    private final By buttonFilling = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']//div[3][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    final By listRolls = By.xpath(".//ul[1][@class='BurgerIngredients_ingredients__list__2A-mT']");
    final By listSauces = By.xpath(".//ul[2][@class='BurgerIngredients_ingredients__list__2A-mT']");
    final By listFilling = By.xpath(".//ul[3][@class='BurgerIngredients_ingredients__list__2A-mT']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click Bar personal account")
    public void clickBarPersonalAccount() {
        driver.findElement(buttonBarPersonalAccount).click();
    }
    @Step("Click logo")
    public void clickLogo() {
        driver.findElement(logo).click();
    }
    @Step("Click button Designer")
    public void clickButtonDesigner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonDesigner));
        driver.findElement(buttonDesigner).click();
    }
    @Step("Click button Inter account")
    public void clickButtonInterAccount() {
        driver.findElement(buttonInterAccount).click();
    }
    @Step("Click button Rolls")
    public void clickButtonRolls() {
        driver.findElement(buttonRolls).click();
    }
    @Step("Click button Sauces")
    public void clickButtonSauces() {
        driver.findElement(buttonSauces).click();
    }
    @Step("Click button Filling")
    public void clickButtonFilling() {
        driver.findElement(buttonFilling).click();
    }
    @Step("Check page Designer is displayed")
    public boolean displayPageDesigner() {
        assertTrue(driver.findElement(pageDesigner).isDisplayed());
        return false;
    }
    @Step("Open Main page")
    public void openMainPage() {
        driver.get(MAIN_PAGE);
    }
}