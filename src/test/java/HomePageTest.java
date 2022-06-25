
import com.codeborne.selenide.Configuration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class HomePageTest  {

    @Before
    public void setupBrowser() {

        Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\yandexdriver.exe");
        //Configuration.browserBinary = "C:\\Users\\Administrator\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Users\\Administrator\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        Configuration.startMaximized = true;

    }

    @Test
    public void checkClickTabSouseThanScrollToHeaderSouse() {
        open(HomePage.URL);

        HomePage homePage = page (HomePage.class);

        homePage.clickTabSouseConstructor();
        //homePage.isHeaderSouseConstructorVisible();
        homePage.isHeaderBunConstructorNotVisible();


        /*$(byXpath(".//h1[text()='Соберите бургер']/following::div/span[text()='Начинки']")).click();
        $(byXpath(".//h2[text()='Начинки']")).shouldBe(Condition.visible);
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/span[text()='Соусы']")).click();
        $(byXpath(".//h2[text()='Соусы']")).shouldBe(Condition.visible);
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/span[text()='Булки']")).click();
        $(byXpath(".//h2[text()='Булки']")).shouldBe(Condition.visible);*/
    }

    @Test
    public void checkClickTabFillingThanScrollToHeaderFilling() {
        open(HomePage.URL);

        HomePage homePage = page (HomePage.class);

        homePage.clickTabFillingsConstructor();
        homePage.isHeaderFillingConstructorVisible();
        //homePageisHeaderBunConstructorNotVisible();
        homePage.isHeaderSouseConstructorNotVisible();

    }


    @Test
    public void checkClickTabBanThanScrollToHeaderBan() {
        open(HomePage.URL);

        HomePage homePage = page (HomePage.class);

        //homePage.clickTabSouseConstructor();
        homePage.clickTabFillingsConstructor();
        //homePage.isHeaderFillingConstructorVisible();
        //homePage.isHeaderBunConstructorNotVisible();
        homePage.clickTabBanConstructor();
        homePage.isHeaderBunConstructorVisible();
        homePage.isHeaderSouseConstructorNotVisible();

    }

    @AfterClass
    public static void tearDown() {
       closeWebDriver();
    }
}
