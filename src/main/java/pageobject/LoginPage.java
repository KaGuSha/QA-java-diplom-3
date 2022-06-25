package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.webdriver;

public class LoginPage extends BasePage{

    public static final String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH,using=".//h2[text()='Вход']/following::div/label[text()='Email']/following-sibling::input[@name='name']")
    private SelenideElement inputEmailForLogin;

    @FindBy(how = How.XPATH,using=".//h2[text()='Вход']/following::div/label[text()='Пароль']/following-sibling::input[@name='Пароль']")
    private SelenideElement inputPasswordForLogin;

    @FindBy(how = How.XPATH,using=".//h2[text()='Вход']/following::form/button[text()='Войти']")
    private SelenideElement btnLoginInLogin;

    public void setInputPasswordForLogin(String password) {
        inputPasswordForLogin.setValue(password);
    }

    public void setInputEmailForLogin(String email) {
        inputEmailForLogin.setValue(email);
    }

    public void clickBtnLoginToPersonalAccount() {
        btnLoginInLogin.click();
    }

    public void isOpenLoginPage() {
        webdriver().shouldHave(WebDriverConditions.url(URL_LOGIN));
    }

    public void isBtnLoginInLoginVisible() {
        btnLoginInLogin.shouldBe(Condition.visible);
    }
}
