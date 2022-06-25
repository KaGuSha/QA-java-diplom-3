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
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
