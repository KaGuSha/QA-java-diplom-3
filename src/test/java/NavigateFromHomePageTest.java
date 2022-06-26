import api.users.User;
import api.users.UserClient;
import com.codeborne.selenide.Configuration;
import io.restassured.response.Response;
import org.junit.*;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;

import static com.codeborne.selenide.Selenide.*;


public class NavigateFromHomePageTest {
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
        LoginPage loginPage = open(LoginPage.URL_LOGIN,LoginPage.class);
        loginPage.setUserDataForLogin(user);
        loginPage.clickBtnLoginToPersonalAccount();
    }

    @Test
    public void checkMovementToProfilePageByClickProfileForAuthUser() {
        HomePage homePage = page(HomePage.class);
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
    public static void removeUser() {
        Response response = userClient.sentDeleteToRemoveUser(accessToken);
        userClient.compareResponseCodeAndBodyAboutRemove(response);
    }
}
