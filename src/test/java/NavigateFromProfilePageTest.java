import api.users.User;
import api.users.UserClient;

import com.codeborne.selenide.Configuration;
import io.restassured.response.Response;
import org.junit.*;

import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;

import static com.codeborne.selenide.Selenide.*;


public class NavigateFromProfilePageTest {
    LoginPage loginPage;
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

    @Before
    public void setUp() {

        Configuration.startMaximized = true;

        loginPage = open(LoginPage.URL_LOGIN,LoginPage.class);
        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();
    }

    @Test
    public void checkGoToPersonalAccountForAuthUser() {

        HomePage homePage = page(HomePage.class);
        homePage.clickBtnLinkToProfile();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isOpenPersonalAccountPage();
        profilePage.isEqualsUserNameExpectedName(user.getName());
        profilePage.isEqualsUserEmailExpectedEmail(user.getEmail());
    }

    @Test
    public void checkGoToConstructor() {
        HomePage homePage = page(HomePage.class);
        homePage.clickBtnLinkToProfile();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isOpenPersonalAccountPage();

        profilePage.clickBtnLinkBurgerContractor();
        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();
    }

    @Test
    public void checkGoToLogo() {
        HomePage homePage = page(HomePage.class);
        homePage.clickBtnLinkToProfile();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isOpenPersonalAccountPage();

        profilePage.clickLogoStellarBurger();
        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();
    }

    @Test
    public void checkLogout() {
        HomePage homePage = page(HomePage.class);
        homePage.clickBtnLinkToProfile();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.isOpenPersonalAccountPage();

        profilePage.clickBtnLogoutPersonalAccount();
        loginPage.isOpenLoginPage();
        loginPage.isBtnLoginInLoginVisible();
    }

    @After
    public void tearDownAfter() {
        clearBrowserLocalStorage();
    }

    @AfterClass
    public static void tearDown() {
        Response response = userClient.sentDeleteToRemoveUser(accessToken);
        userClient.compareResponseCodeAndBodyAboutRemove(response);
    }
}
