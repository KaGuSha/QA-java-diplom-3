import com.codeborne.selenide.Configuration;
import api.users.User;
import org.junit.Before;
import org.junit.Test;
import pageobject.*;


import static com.codeborne.selenide.Selenide.*;



public class RegistrationTest {

    @Before
    public void setupBrowser() {

        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

    }

    @Test
    public void checkUserRegistrationSuccess() {
        User user1 = User.getUser1();

        open(RegistrationPage.URL_REGISTRATION);
        RegistrationPage registrationPage = page(RegistrationPage.class);


        registrationPage.setUserDataInInputFields(user1);
        registrationPage.clickBtnRegistration();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.isOpenLoginPage();

        /*
        $(byXpath("//div/label[text()='Имя']/following-sibling::input")).setValue("Gulnara2");
        $(byXpath(".//div/label[text()='Email']/following-sibling::input")).setValue("22062022test@test.test");
        $(byXpath(".//div/label[text()='Пароль']/following-sibling::input")).setValue("22062022test");
        $(byXpath(".//form/button[text()='Зарегистрироваться']")).click();
        //проверка
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/login"));*/
    }

    @Test
    public void checkUserRegistrationPasswordWarning() {

        User user1 = User.getUserPass5();
        open(RegistrationPage.URL_REGISTRATION);

        RegistrationPage registrationPage = page(RegistrationPage.class);

        registrationPage.setUserDataInInputFields(user1);
        registrationPage.clickBtnRegistration();

        registrationPage.isMessageWrongPasswordLengthVisible();

        /*
        $(byXpath("//div/label[text()='Имя']/following-sibling::input[@name='name']")).setValue("Gulnara2");
        $(byXpath(".//div/label[text()='Email']/following-sibling::input[@name='name']")).setValue("22062022test@test.test");
        $(byXpath(".//div/label[text()='Пароль']/following-sibling::input[@name='Пароль'")).setValue("test");
        $(byXpath(".//form/button[text()='Зарегистрироваться']")).click();
        $(byCssSelector("p.input__error")).shouldHave(Condition.exactText("Некорректный пароль"));*/
    }





}
