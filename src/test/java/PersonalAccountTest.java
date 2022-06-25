import api.users.User;
import org.junit.Test;
import pageobject.BasePage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.open;

public class PersonalAccountTest {

    @Test
    public void checkGoToPersonalAccountForAuthUser() {

        User user = User.getUser1();

        open(HomePage.URL);
        HomePage homePage = new HomePage();
        BasePage basePage = new BasePage();
        homePage.clickBtnLoginInHomePage();
        LoginPage loginPage = new LoginPage();
        loginPage.isOpenLoginPage();

        loginPage.setInputEmailForLogin(user.getEmail());
        loginPage.setInputPasswordForLogin(user.getPassword());
        loginPage.clickBtnLoginToPersonalAccount();

        homePage.isOpenHomePage();
        basePage.clickBtnLinkPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        personalAccountPage.isOpenPersonalAccountPage();
        personalAccountPage.isEqualsUserNameExpectedName(user.getName());
        personalAccountPage.isEqualsUserEmailExpectedEmail(user.getEmail());

        /*
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
        $(byXpath("//a/p[text()='Личный Кабинет']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/account/profile"));
        $(byXpath("//div/label[text()='Имя']/following-sibling::input[@name='Name']")).shouldHave(Condition.value("Gulnara2"));
        $(byXpath("//div/label[text()='Логин']/following-sibling::input[@name='name']")).shouldHave(Condition.value("22062022test@test.test"));*/
    }

    @Test
    public void checkGoToConstructor() {
        User user = User.getUser1();

        open(HomePage.URL);
        HomePage homePage = new HomePage();
        BasePage basePage = new BasePage();
        homePage.clickBtnLoginInHomePage();
        LoginPage loginPage = new LoginPage();
        loginPage.isOpenLoginPage();

        loginPage.setInputEmailForLogin(user.getEmail());
        loginPage.setInputPasswordForLogin(user.getPassword());
        loginPage.clickBtnLoginToPersonalAccount();

        homePage.isOpenHomePage();
        basePage.clickBtnLinkPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        personalAccountPage.isOpenPersonalAccountPage();

        basePage.clickBtnLinkBurgerContractor();
        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();

        /*
        open(linkFor);
        $(byXpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
        $(byXpath("//a/p[text()='Личный Кабинет']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/account/profile"));
        $(byXpath("//div/label[text()='Имя']/following-sibling::input[@name='Name']")).shouldHave(Condition.value("Gulnara2"));
        $(byXpath("//div/label[text()='Логин']/following-sibling::input[@name='name']")).shouldHave(Condition.value("22062022test@test.test"));

        $(byXpath(".//a/p[text()='Конструктор']")).click();
        //$(byXpath(".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);*/
    }

    @Test
    public void checkGoToLogo() {
        User user = User.getUser1();

        open(HomePage.URL);
        HomePage homePage = new HomePage();
        BasePage basePage = new BasePage();
        homePage.clickBtnLoginInHomePage();
        LoginPage loginPage = new LoginPage();
        loginPage.isOpenLoginPage();

        loginPage.setInputEmailForLogin(user.getEmail());
        loginPage.setInputPasswordForLogin(user.getPassword());
        loginPage.clickBtnLoginToPersonalAccount();

        homePage.isOpenHomePage();
        basePage.clickBtnLinkPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        personalAccountPage.isOpenPersonalAccountPage();

        basePage.clickLogoStellarBurger();
        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();

        /*
        open(linkFor);
        $(byXpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
        $(byXpath("//a/p[text()='Личный Кабинет']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/account/profile"));
        $(byXpath("//div/label[text()='Имя']/following-sibling::input[@name='Name']")).shouldHave(Condition.value("Gulnara2"));
        $(byXpath("//div/label[text()='Логин']/following-sibling::input[@name='name']")).shouldHave(Condition.value("22062022test@test.test"));

        $(byXpath(".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);*/
    }

    @Test
    public void checkLogout() {
        User user = User.getUser1();

        open(HomePage.URL);
        HomePage homePage = new HomePage();
        BasePage basePage = new BasePage();
        homePage.clickBtnLoginInHomePage();
        LoginPage loginPage = new LoginPage();
        loginPage.isOpenLoginPage();

        loginPage.setInputEmailForLogin(user.getEmail());
        loginPage.setInputPasswordForLogin(user.getPassword());
        loginPage.clickBtnLoginToPersonalAccount();

        homePage.isOpenHomePage();
        basePage.clickBtnLinkPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        personalAccountPage.isOpenPersonalAccountPage();

        personalAccountPage.clickBtnLogoutPersonalAccount();
        loginPage.isOpenLoginPage();
        loginPage.isBtnLoginInLoginVisible();

        /*
        open(linkFor);
        $(byXpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
        $(byXpath("//a/p[text()='Личный Кабинет']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/account/profile"));
        $(byXpath(".//nav//button[text()='Выход']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).shouldBe(Condition.visible);

        //$(byXpath("//div/label[text()='Имя']/following-sibling::input[@name='Name']")).shouldHave(Condition.value("Gulnara2"));
        //$(byXpath("//div/label[text()='Логин']/following-sibling::input[@name='name']")).shouldHave(Condition.value("22062022test@test.test"));*/

    }
}
