import api.users.UserClient;
import api.users.UserCredentials;
import com.codeborne.selenide.Configuration;
import api.users.User;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
    private User user;
    private RegistrationPage registrationPage;

    @Before
    public void setupBrowser() {

        Configuration.browser = "chrome";

        registrationPage = open(RegistrationPage.URL_REGISTRATION,RegistrationPage.class);
    }

    @Test
    public void checkUserRegistrationSuccess() {
        user = User.getUser1();

        registrationPage.setUserDataInInputFields(user);
        registrationPage.clickBtnRegistration();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();

        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();
        HomePage homePage = page(HomePage.class);
        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();
    }

    @Test
    public void checkUserRegistrationPasswordWarning() {
        user = User.getUserPass5();

        registrationPage.setUserDataInInputFields(user);
        registrationPage.clickBtnRegistration();

        registrationPage.isMessageWrongPasswordLengthVisible();
    }

    @After
    public void tearDown() {
        if (user.getPassword().length() >= 6) {
            UserClient userClient = new UserClient();
            UserCredentials userCredentials = UserCredentials.from(user);
            Response response = userClient.sentPostToLogin(userCredentials);
            String accessToken = userClient.compareResponseCode200AndBodySuccessTrueAndReturnToken(response);
            userClient.sentDeleteToRemoveUser(accessToken);
        }
    }
}
