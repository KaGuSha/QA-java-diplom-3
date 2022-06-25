import api.users.User;
import org.junit.Test;
import pageobject.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest {

    @Test
    public void checkLoginInHeaderPersonalAccount() {
        open(HomePage.URL);
        User user = User.getUser1();

        BasePage header = new BasePage();
        header.clickBtnLinkPersonalAccount();

        LoginPage loginPage = new LoginPage();

        loginPage.isOpenLoginPage();
        loginPage.setInputEmailForLogin(user.getEmail());
        loginPage.setInputPasswordForLogin(user.getPassword());
        loginPage.clickBtnLoginToPersonalAccount();

        HomePage homePage = new HomePage();
        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();

        /*
        $(byXpath("//a/p[text()='Личный Кабинет']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following-sibling::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();

        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);*/
    }

    @Test
    public void checkLoginInMainPage() {
        open(HomePage.URL);
        User user = User.getUser1();

        HomePage homePage = new HomePage();
        homePage.clickBtnLoginInHomePage();

        LoginPage loginPage = new LoginPage();
        loginPage.isOpenLoginPage();

        loginPage.setInputEmailForLogin(user.getEmail());
        loginPage.setInputPasswordForLogin(user.getPassword());
        loginPage.clickBtnLoginToPersonalAccount();

        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();

        /*
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Войти в аккаунт']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);*/

    }

    @Test
    public void checkLoginInRegistrationPage() {

        User user = User.getUser1();
        open(RegistrationPage.URL_REGISTRATION);
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickBtnLinkLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.isOpenLoginPage();

        loginPage.setInputEmailForLogin(user.getEmail());
        loginPage.setInputPasswordForLogin(user.getPassword());
        loginPage.clickBtnLoginToPersonalAccount();

        HomePage homePage = new HomePage();

        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();

        /*
        $(byXpath(".//p[text()='Уже зарегистрированы?']/a[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);*/

    }

    @Test
    public void checkLoginForgotPasswordPage() {
        User user = User.getUser1();
        open(ForgotPasswordPage.URL_FORGOT);

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.clickBntLinkLoginInForgotPage();

        LoginPage loginPage = new LoginPage();
        loginPage.isOpenLoginPage();

        loginPage.setInputEmailForLogin(user.getEmail());
        loginPage.setInputPasswordForLogin(user.getPassword());
        loginPage.clickBtnLoginToPersonalAccount();

        HomePage homePage = new HomePage();

        homePage.isOpenHomePage();
        homePage.isBtnMakeOrderInHomePageVisible();

        /*$(byXpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);*/
    }
}
