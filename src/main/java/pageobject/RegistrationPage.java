package pageobject;

import api.users.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class RegistrationPage extends BasePage {

    public static final String URL_REGISTRATION = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how= How.XPATH,using=".//div/label[text()='Имя']/following-sibling::input[@name='name']")
    private SelenideElement inputNameForRegistration;

    @FindBy(how= How.XPATH,using=".//div/label[text()='Email']/following-sibling::input[@name='name']")
    private SelenideElement inputEmailForRegistration;

    @FindBy(how= How.XPATH,using=".//div/label[text()='Пароль']/following-sibling::input[@name='Пароль']")
    private SelenideElement inputPasswordForRegistration;

    @FindBy(how= How.XPATH,using=".//form/button[text()='Зарегистрироваться']")
    private SelenideElement btnRegistration;

    @FindBy(how= How.CSS,using="p.input__error")
    private SelenideElement msgWrongPasswordLength;

    @FindBy(how = How.XPATH, using = ".//p[text()='Уже зарегистрированы?']/a[text()='Войти']")
    private SelenideElement btnLinkLoginInRegistrationPage;

    @Step("Нажать на кнопку Зарегистрировать")
    public void clickBtnRegistration () {
        btnRegistration.shouldBe(Condition.enabled).click();
    }

    @Step("Нажать на ссылку Войти для перехода на страницу Авторизации")
    public void clickBtnLinkLogin () {
        btnLinkLoginInRegistrationPage.shouldBe(Condition.visible).click();
    }

    @Step("Проверить, что открыта страница регистрации пользователя")
    public void isOpenRegistrationPage() {
        webdriver().shouldHave(WebDriverConditions.url("https://stellarburgers.nomoreparties.site/register"));
    }

    @Step("Проверить, что отображается сообщение Некорректный пароль")
    public void isMessageWrongPasswordLengthVisible() {
        msgWrongPasswordLength.shouldHave(Condition.exactText("Некорректный пароль"));
    }

    @Step("Указать имя в поле Имя")
    public void setInputNameForRegistration (String name) {
        inputNameForRegistration.sendKeys(name);
    }

    @Step("Указать email в поле email")
    public void setInputEmailForRegistration (String email) {
        inputEmailForRegistration.sendKeys(email);
    }

    @Step("Указать пароль в поле пароль")
    public void setInputPasswordForRegistration (String password) {
        inputPasswordForRegistration.sendKeys(password);
    }

    @Step("Заполнить форму для регистрации нового пользователя")
    public void setUserDataInInputFields(User user){
        setInputNameForRegistration(user.getName());
        setInputEmailForRegistration(user.getEmail());
        setInputPasswordForRegistration(user.getPassword());
    }
}
