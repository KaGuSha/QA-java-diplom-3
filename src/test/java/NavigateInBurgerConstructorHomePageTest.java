import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class NavigateInBurgerConstructorHomePageTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setupBrowser() {
        //Configuration.browser = "firefox";
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\yandexdriver.exe");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--disable-background-mode");
        options.addArguments("--profile-directory=Test profile");
        options.addArguments("--start-maximized");
        driver =  new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }

    @DisplayName("Переход к разделу Соусы по клику на таб Соусы")
    @Test
    public void checkMovementToHeaderSouseByClickTabSouse() {
        HomePage homePage = open(HomePage.URL,HomePage.class);
        int before = homePage.getHeaderSouseLocation();

        homePage.clickTabSouseInConstructor();
        int actual = homePage.getHeaderSouseLocation();

        homePage.isElementPositionChanged(before,actual);
    }

    @DisplayName("Переход к разделу Начинки по клику на таб Начинки")
    @Test
    public void checkMovementToHeaderFillingByClickTabFilling() {
        HomePage homePage = open(HomePage.URL,HomePage.class);
        int before = homePage.getHeaderFillingLocation();

        homePage.clickTabFillingsInConstructor();
        int actual = homePage.getHeaderFillingLocation();

        homePage.isElementPositionChanged(before,actual);
    }

    @DisplayName("Переход к разделу Булки по клику на таб Булки")
    @Test
    public void checkMovementToHeaderBanByClickTabBan() {
        HomePage homePage = open(HomePage.URL,HomePage.class);
        homePage.clickTabFillingsInConstructor();
        int before = homePage.getHeaderBanLocation();

        homePage.clickTabBanInConstructor();
        int actual = homePage.getHeaderBanLocation();

        homePage.isElementPositionChanged(before,actual);
    }

    @After
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @AfterClass
    public static void tearDownBrowser (){
        WebDriverRunner.closeWebDriver();
    }
}
