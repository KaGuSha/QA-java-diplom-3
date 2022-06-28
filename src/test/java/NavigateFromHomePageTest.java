import api.users.User;
import api.users.UserClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;

import static com.codeborne.selenide.Selenide.*;


public class NavigateFromHomePageTest {
    private static User user;
    private static UserClient userClient;
    private static String accessToken;
    private static WebDriver driver;

    @BeforeClass
    public static void createUser() {
        user = User.getUser1();
        userClient = new UserClient();
        Response response = userClient.sentPostToCreateUser(user);
        accessToken = userClient.compareResponseCode200AndBodySuccessTrueAndReturnToken(response);
    }

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

    @DisplayName("Переход в Личный кабинет для авторизованного пользователя")
    @Description("По кнопке Личный кабинет для авторизованного пользователя доступна страница Личного кабинета. Для неавторизованного пользователя происходит переход на страницу Авторизации.")
    @Test
    public void checkMovementToProfilePageByClickProfileForAuthUser() {
        LoginPage loginPage = open(LoginPage.URL_LOGIN,LoginPage.class);
        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();

        HomePage homePage = page(HomePage.class);
        homePage.isOpenHomePageForAuthUser();
        homePage.clickBtnLinkToProfile();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isOpenPersonalAccountPage();
        profilePage.isEqualsUserNameExpectedName(user.getName());
        profilePage.isEqualsUserEmailExpectedEmail(user.getEmail());
    }

    @After
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @AfterClass
    public static void tearDownBrowser (){
        WebDriverRunner.closeWebDriver();
    }

    @AfterClass
    public static void removeUser() {
        Response response = userClient.sentDeleteToRemoveUser(accessToken);
        userClient.compareResponseCodeAndBodyAboutRemove(response);
    }
}
