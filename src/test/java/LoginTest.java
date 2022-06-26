import api.users.User;
import api.users.UserClient;
import com.codeborne.selenide.Configuration;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.*;
import pageobject.*;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    private static User user;
    private static UserClient userClient;
    private static String accessToken;

    @BeforeClass
    public static void createUser() {
        user = User.getUser2();
        userClient = new UserClient();
        Response response = userClient.sentPostToCreateUser(user);
        accessToken = userClient.compareResponseCode200AndBodySuccessTrueAndReturnToken(response);
    }

    @BeforeClass
    public static void setupBrowser() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\yandexdriver.exe");
        //Configuration.browserBinary = "C:\\Users\\Administrator\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        //Configuration.browser = "firefox";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @DisplayName("Вход через кнопку Личный кабинет")
    @Test
    public void checkLoginInHeaderPersonalAccount() {
        HomePage homePage = open(HomePage.URL, HomePage.class);

        homePage.clickBtnLinkToProfile();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();
        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();

        homePage.isOpenHomePageForAuthUser();
    }

    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    @Test
    public void checkLoginInMainPage() {
        HomePage homePage = open(HomePage.URL, HomePage.class);

        homePage.clickBtnLoginInHomePage();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();
        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();

        homePage.isOpenHomePageForAuthUser();
    }

    @DisplayName("Вход через кнопку Войти в форме регистрации")
    @Test
    public void checkLoginInRegistrationPage() {
        RegistrationPage registrationPage = open(RegistrationPage.URL_REGISTRATION, RegistrationPage.class);

        registrationPage.clickBtnLinkLogin();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();
        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();

        HomePage homePage = page(HomePage.class);
        homePage.isOpenHomePageForAuthUser();
    }

    @DisplayName("Вход через кнопку Войти в форме восстановления пароля")
    @Test
    public void checkLoginForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.URL_FORGOT, ForgotPasswordPage.class);

        forgotPasswordPage.clickBntLinkLoginInForgotPage();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();
        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();

        HomePage homePage = page(HomePage.class);
        homePage.isOpenHomePageForAuthUser();
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
