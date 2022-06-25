import api.users.UserClient;
import api.users.UserCredentials;

import com.codeborne.selenide.Configuration;
import api.users.User;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;


import static com.codeborne.selenide.AuthenticationType.BEARER;
import static com.codeborne.selenide.Selenide.*;


public class LoginTest2 {
    private User user1;

    @Before
    public void setupBrowser() {
        Configuration.browser = "chrome";
        //Configuration.startMaximized = true;
    }

    @Test
    public void checkUserRegistrationSuccess() {
        user1 = User.getUser1();

        open(LoginPage.URL_LOGIN);
        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();

        loginPage.setUserDataForLogin(user1);
        loginPage.clickBtnLoginToPersonalAccount();
        HomePage homePage = page(HomePage.class);
        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();

        //open(ProfilePage.URL_ACCOUNT,BEARER,new BearerTokenCredentials(accessToken));
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