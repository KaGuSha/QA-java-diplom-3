import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistationSeleniumTest {

    private WebDriver driver;
    private String link="https://stellarburgers.nomoreparties.site/register";

    @Before
    public void setupBrowser() {
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
