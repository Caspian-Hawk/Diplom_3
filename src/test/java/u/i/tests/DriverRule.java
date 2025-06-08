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

    public void createUserData() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String name = faker.name().fullName();
        userData = new UserData(email, password, name);

        // Создание пользователя через API
        given()
                .contentType(JSON)
                .body(userData)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public void loginUser() {
        // Логин пользователя и получение токена
        String requestBody = String.format("{\"email\":\"%s\",\"password\":\"%s\"}", userData.getEmail(), userData.getPassword());

        String response = given()
                .contentType(JSON)
                .body(requestBody)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("accessToken"); // Извлекаем accessToken из ответа

        accessToken = response; // Сохраняем accessToken
    }

    private void deleteUser() {
        // Убедитесь, что вы сначала авторизовались, чтобы получить accessToken
        loginUser(); // Получаем токен перед удалением пользователя

        // Удаление пользователя через API
        given()
                .header("Authorization", accessToken) // Используем accessToken
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
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