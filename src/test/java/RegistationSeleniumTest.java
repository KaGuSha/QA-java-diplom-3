import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegistationSeleniumTest {

    private WebDriver driver;

    private String link="https://stellarburgers.nomoreparties.site/register";

    @Before
    public void setupBrowser() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void checkRegistrationSuccess() {
        driver.get(link);

        /*
        $(byXpath("//a/p[text()='Личный Кабинет']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following-sibling::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);*/
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
