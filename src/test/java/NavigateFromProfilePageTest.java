import api.users.User;
import api.users.UserClient;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.*;

import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;

import static com.codeborne.selenide.Selenide.*;


public class NavigateFromProfilePageTest {
    LoginPage loginPage;
    HomePage homePage;
    private static User user;
    private static UserClient userClient;
    private static String accessToken;

    @BeforeClass
    public static void createUser() {
        user = User.getUser1();
        userClient = new UserClient();
        Response response = userClient.sentPostToCreateUser(user);
        accessToken = userClient.compareResponseCode200AndBodySuccessTrueAndReturnToken(response);
    }

    @BeforeClass
    public static void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\yandexdriver.exe");
        //Configuration.browserBinary = "C:\\Users\\Administrator\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Before
    public void setUp() {
        loginPage = open(LoginPage.URL_LOGIN, LoginPage.class);
        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();

        HomePage homePage = page(HomePage.class);
        homePage.clickBtnLinkToProfile();
    }

    @DisplayName("Переход из Личного кабинета на главную по клику на Конструктор")
    @Test
    public void checkMovementToHomePageFromProfilePageByClickConstructorForAuthUser() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isOpenPersonalAccountPage();

        profilePage.clickBtnLinkBurgerContractor();
        homePage.isOpenHomePageForAuthUser();
    }

    @DisplayName("Переход из Личного кабинета на главную по клику на логотип")
    @Test
    public void checkMovementToHomePageFromProfilePageByClickLogoForAuthUser() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isOpenPersonalAccountPage();

        profilePage.clickLogoStellarBurger();
        homePage.isOpenHomePageForAuthUser();
    }

    @DisplayName("Выход из Личного кабинета по кнопке Выход")
    @Test
    public void checkLogoutForAuthUser() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isOpenPersonalAccountPage();

        profilePage.clickBtnLogoutPersonalAccount();
        loginPage.isOpenLoginPage();
        loginPage.isBtnLoginInLoginVisible();
    }

    @After
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @AfterClass
    public static void removeUser() {
        Response response = userClient.sentDeleteToRemoveUser(accessToken);
        userClient.compareResponseCodeAndBodyAboutRemove(response);
    }
}
