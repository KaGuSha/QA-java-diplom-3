import com.codeborne.selenide.Configuration;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pageobject.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class NavigateInBurgerConstructorHomePageTest {
    private HomePage homePage;

    @BeforeClass
    public static void setupBrowser() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\yandexdriver.exe");
        //Configuration.browserBinary = "C:\\Users\\Administrator\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        //Configuration.browser = "firefox";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Before
    public void setUp() {
        homePage = open(HomePage.URL,HomePage.class);
    }

    @DisplayName("Переход к разделу Соусы по клику на таб Соусы")
    @Test
    public void checkMovementToHeaderSouseByClickTabSouse() {
        int before = homePage.getHeaderSouseLocation();

        homePage.clickTabSouseInConstructor();
        int actual = homePage.getHeaderSouseLocation();

        homePage.isElementPositionChanged(before,actual);
    }

    @DisplayName("Переход к разделу Начинки по клику на таб Начинки")
    @Test
    public void checkMovementToHeaderFillingByClickTabFilling() {
        int before = homePage.getHeaderFillingLocation();

        homePage.clickTabFillingsInConstructor();
        int actual = homePage.getHeaderFillingLocation();

        homePage.isElementPositionChanged(before,actual);
    }

    @DisplayName("Переход к разделу Булки по клику на таб Булки")
    @Test
    public void checkMovementToHeaderBanByClickTabBan() {
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
}
