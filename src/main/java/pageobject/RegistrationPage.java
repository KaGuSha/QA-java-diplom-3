package pageobject;

import api.users.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
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


    public void setInputNameForRegistration (String name) {
        inputNameForRegistration.setValue(name);
    }

    public void setInputEmailForRegistration (String email) {
        inputEmailForRegistration.setValue(email);
    }

    public void setInputPasswordForRegistration (String password) {
        inputPasswordForRegistration.setValue(password);
    }

    public void setUserDataInInputFields(User user){
        setInputNameForRegistration(user.getName());
        setInputEmailForRegistration(user.getEmail());
        setInputPasswordForRegistration(user.getPassword());
    }

    public void clickBtnRegistration () {
        btnRegistration.click();
    }

    public void clickBtnLinkLogin () {
        btnLinkLoginInRegistrationPage.click();
    }

    public void isOpenRegistrationPage() {
        webdriver().shouldHave(WebDriverConditions.url("https://stellarburgers.nomoreparties.site/register"));
    }

    public void isMessageWrongPasswordLengthVisible() {
        msgWrongPasswordLength.shouldHave(Condition.exactText("Некорректный пароль"));
    }

}
