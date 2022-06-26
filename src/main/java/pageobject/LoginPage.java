package pageobject;

import api.users.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;


public class LoginPage extends BasePage{

    public static final String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH,using=".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")
    private SelenideElement inputEmailForLogin;

    @FindBy(how = How.XPATH,using=".//h2[text()='Вход']/following::div/label[text()='Пароль']/following-sibling::input[@name='Пароль']")
    private SelenideElement inputPasswordForLogin;

    @FindBy(how = How.XPATH,using=".//form/button[text()='Войти']")
    private SelenideElement btnLoginInLogin;

    @Step("Нажать на кнопку Войти для авторизации")
    public void clickBtnLoginToPersonalAccount() {
        //btnLoginInLogin.shouldBe(Condition.visible, Duration.ofSeconds(5)).doubleClick();

        btnLoginInLogin.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    @Step("Проверить, что пароль введен")
    public void checkPasswordInputValue(User user) {
        MatcherAssert.assertThat(inputPasswordForLogin.getValue(), Matchers.is(user.getPassword()));
    }

    @Step("Проверить, что открыта страница авторизации пользователя")
    public Boolean isOpenLoginPage() {
        if(WebDriverRunner.url()==URL_LOGIN) {
            return true;
        }
        return false;
    }

    @Step("Проверить, что кнопка Войти отображается на странице")
    public void isBtnLoginInLoginVisible() {
        btnLoginInLogin.shouldBe(Condition.visible);
    }

    @Step("Указать пароль в поле пароль")
    public void setInputPasswordForLogin(String password) {
        if(inputPasswordForLogin.getValue().length()==0){
            inputPasswordForLogin.setValue(password);
        }
    }

    @Step("Указать email в поле email")
    public void setInputEmailForLogin(String email) {
        if(inputEmailForLogin.getValue().length()!=0){
            inputEmailForLogin.clear();
        }
        inputEmailForLogin.sendKeys(email);
        //inputEmailForLogin.setValue(email);
    }

    @Step("Заполнить форму авторизации пользователя данными пользователя")
    public void setUserDataForLogin(User user) {
        setInputEmailForLogin(user.getEmail());
        setInputPasswordForLogin(user.getPassword());
    }
}
