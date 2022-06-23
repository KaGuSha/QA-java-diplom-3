import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class RegistrationTest {
    private String linkFor= "https://stellarburgers.nomoreparties.site/forgot-password";
    private String linkReg= "https://stellarburgers.nomoreparties.site/register";
    private String link= "https://stellarburgers.nomoreparties.site";

    @Before
    public void setupBrowser() {

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

    }

    @Test
    public void checkUserRegistrationSuccess() {
        open(linkReg);
        $(byXpath("//div/label[text()='Имя']/following-sibling::input")).setValue("Gulnara2");
        $(byXpath(".//div/label[text()='Email']/following-sibling::input")).setValue("22062022test@test.test");
        $(byXpath(".//div/label[text()='Пароль']/following-sibling::input")).setValue("22062022test");
        $(byXpath(".//form/button[text()='Зарегистрироваться']")).click();
        //проверка
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
    }

    @Test
    public void checkUserRegistrationPasswordWarning() {
        open(linkReg);
        $(byXpath("//div/label[text()='Имя']/following-sibling::input[@name='name']")).setValue("Gulnara2");
        $(byXpath(".//div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//div/label[text()='Пароль']/following-sibling::input[@name='Пароль'")).setValue("test");
        $(byXpath(".//form/button[text()='Зарегистрироваться']")).click();
        $(byCssSelector("p.input__error")).shouldHave(Condition.exactText("Некорректный пароль"));
    }

    @Test
    public void checkLoginHeader() {
        open(link);
        $(byXpath("//a/p[text()='Личный Кабинет']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following-sibling::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
    }

    @Test
    public void checkLoginMainVoity() {
        open(link);
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Войти в аккаунт']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
    }

    @Test
    public void checkLoginMainRegistration() {
        open(linkReg);
        $(byXpath(".//p[text()='Уже зарегистрированы?']/a[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
    }

    @Test
    public void checkLoginMainForgotPassword() {
        open(linkFor);
        $(byXpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//h2[text()='Вход']/following::div/label[text()='Пароль']/following::input[@name='Пароль']")).setValue("22062022test");
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
    }

    @Test
    public void checkGoToAccountForAuth() {
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
     }

    @Test
    public void checkGoToConstructor() {
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
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
    }

    @Test
    public void checkGoToLogo() {
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
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")).shouldBe(Condition.visible);
    }

    @Test
    public void checkLogout() {
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
        $(byXpath(".//nav//button[text()=\'Выход\']")).click();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));
        $(byXpath(".//h2[text()='Вход']/following::form/button[text()='Войти']")).shouldBe(Condition.visible);

        //$(byXpath("//div/label[text()='Имя']/following-sibling::input[@name='Name']")).shouldHave(Condition.value("Gulnara2"));
        //$(byXpath("//div/label[text()='Логин']/following-sibling::input[@name='name']")).shouldHave(Condition.value("22062022test@test.test"));
    }

    @Test
    public void checkMainConstructor() {
        open(link);

        $(byXpath(".//h1[text()='Соберите бургер']/following::div/span[text()='Начинки']")).click();
        $(byXpath(".//h2[text()='Начинки']")).shouldBe(Condition.visible);
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/span[text()='Соусы']")).click();
        $(byXpath(".//h2[text()='Соусы']")).shouldBe(Condition.visible);
        $(byXpath(".//h1[text()='Соберите бургер']/following::div/span[text()='Булки']")).click();
        $(byXpath(".//h2[text()='Булки']")).shouldBe(Condition.visible);

    }


}
