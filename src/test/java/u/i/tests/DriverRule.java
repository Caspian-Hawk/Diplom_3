package u.i.tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpStatus;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static u.i.tests.Constant.*;
import io.restassured.response.ValidatableResponse;

public class DriverRule extends ExternalResource {

    private WebDriver driver;
    private Faker faker = new Faker();
    private UserData userData;
    private String accessToken;

    public WebDriver getDriver() {
        return driver;
    }

    public UserData getUserData() {
        return userData; // Метод для получения UserData
    }

    public ValidatableResponse createUserData() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String name = faker.name().fullName();
        userData = new UserData(email, password, name);

        return RestClient.getRequestSpecification()
                .body(userData)
                .when()
                .post(CREATE_USER)
                .then();
    }

    public void loginUser() {
                String response = given()
                .contentType(JSON)
                .body(userData)
                .when()
                .post(LOGIN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("accessToken"); // Извлекаем accessToken из ответа

        accessToken = response; // Сохраняем accessToken
    }

    private void deleteUser() {
        loginUser(); // Получаем токен перед удалением пользователя

        // Удаление пользователя через API
        given()
                .header("Authorization", accessToken) // Используем accessToken
                .when()
                .delete(DELETE_USER)
                .then();
    }

    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            startFirefox();
        } else {
            startChrome();
        }
    }

    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Override
    protected void before() throws Throwable {
        initDriver();
        createUserData();
    }

    @Override
    protected void after() {
        deleteUser();
        driver.quit();
    }
}