import com.codeborne.selenide.Configuration;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pageobject.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class NavigateInBurgerConstructorHomePageTest {
    HomePage homePage;

    @BeforeClass
    public static void setupBrowser() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\yandexdriver.exe");
        //Configuration.browserBinary = "C:\\Users\\Administrator\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Before
    public void setUp() {
        homePage = open(HomePage.URL,HomePage.class);
    }

    @Test
    public void checkMovementToHeaderSouseByClickTabSouse() {
        int before = homePage.getHeaderSouseLocation();

        homePage.clickTabSouseInConstructor();
        int actual = homePage.getHeaderSouseLocation();

        homePage.isElementPositionChanged(before,actual);
    }

    @Test
    public void checkMovementToHeaderFillingByClickTabFilling() {
        int before = homePage.getHeaderFillingLocation();

        homePage.clickTabFillingsInConstructor();
        int actual = homePage.getHeaderFillingLocation();

        homePage.isElementPositionChanged(before,actual);
    }

    @Test
    public void checkMovementToHeaderBanByClickTabBan() {
        homePage.clickTabFillingsInConstructor();
        int before = homePage.getHeaderBanLocation();

        homePage.clickTabBanInConstructor();
        int actual = homePage.getHeaderBanLocation();

        homePage.isElementPositionChanged(before,actual);
    }
}
