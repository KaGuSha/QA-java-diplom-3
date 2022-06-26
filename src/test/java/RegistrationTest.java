import api.users.UserClient;
import api.users.UserCredentials;
import com.codeborne.selenide.Configuration;
import api.users.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import pageobject.*;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
    private User user;


    @BeforeClass
    public static void setupBrowser() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\yandexdriver.exe");
        //Configuration.browserBinary = "C:\\Users\\Administrator\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        //Configuration.browser = "firefox";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @DisplayName("Появление ошибки для некорректного пароля")
    @Description("Минимальная длина пароля — шесть символов")
    @Test
    public void checkUserRegistration1PasswordWarning() {
        user = User.getUserPass5();

        RegistrationPage registrationPage = open(RegistrationPage.URL_REGISTRATION, RegistrationPage.class);
        registrationPage.setUserDataInInputFields(user);
        registrationPage.clickBtnRegistration();

        registrationPage.isMessageWrongPasswordLengthVisible();
    }

    @DisplayName("Успешная регистрация")
    @Description("Для успешной регистрации необходимо заполнить все поля формы")
    @Test
    public void checkUserRegistrationSuccess() {
        user = User.getUser1();

        RegistrationPage registrationPage = open(RegistrationPage.URL_REGISTRATION, RegistrationPage.class);
        registrationPage.setUserDataInInputFields(user);
        registrationPage.clickBtnRegistration();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();
        loginPage.setUserDataForLogin(user);
        loginPage.checkPasswordInputValue(user);
        loginPage.clickBtnLoginToPersonalAccount();

        HomePage homePage = page(HomePage.class);
        homePage.isOpenHomePageForAuthUser();
    }

    @After
    public void tearDown() {
        clearBrowserLocalStorage();
        //WebDriverRunner.closeWindow();
    }

    @After
    public void removeUser() {
        if (user.getPassword().length() >= 6) {
            UserClient userClient = new UserClient();
            UserCredentials userCredentials = UserCredentials.from(user);
            Response response = userClient.sentPostToLogin(userCredentials);
            String accessToken = userClient.compareResponseCode200AndBodySuccessTrueAndReturnToken(response);
            userClient.sentDeleteToRemoveUser(accessToken);
        }
    }
}
