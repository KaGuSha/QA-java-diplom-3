import api.users.UserClient;
import api.users.UserCredentials;
import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import api.users.User;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;


import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
    private User user1;
    private RegistrationPage registrationPage;

    @Before
    public void setupBrowser() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        open(RegistrationPage.URL_REGISTRATION);
        registrationPage = page(RegistrationPage.class);
    }

    @Test
    public void checkUserRegistrationSuccess() {
        user1 = User.getUser1();

        registrationPage.setUserDataInInputFields(user1);
        registrationPage.clickBtnRegistration();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();

        loginPage.setUserDataForLogin(user1);
        loginPage.clickBtnLoginToPersonalAccount();
        HomePage homePage = page(HomePage.class);
        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();
    }

    @Test
    public void checkUserRegistrationPasswordWarning() {
        user1 = User.getUserPass5();
        open(RegistrationPage.URL_REGISTRATION);

        registrationPage.setUserDataInInputFields(user1);
        registrationPage.clickBtnRegistration();

        registrationPage.isMessageWrongPasswordLengthVisible();
    }

    @After
    public void tearDown() {
        if (user1.getPassword().length() >= 6) {
            UserClient userClient = new UserClient();
            UserCredentials userCredentials = UserCredentials.from(user1);
            Response response = userClient.sentPostToLogin(userCredentials);
            String accessToken = userClient.compareResponseCode200AndBodySuccessTrueAndReturnToken(response);
            userClient.sentDeleteToRemoveUser(accessToken);
        }
    }
}
