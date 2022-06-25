package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProfilePage extends BasePage {

    public static final String URL_ACCOUNT = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how= How.XPATH, using = "//div/label[text()='Имя']/following-sibling::input[@name='Name']")
    private SelenideElement fieldUserName;

    @FindBy(how= How.XPATH, using = "//div/label[text()='Логин']/following-sibling::input[@name='name']")
    private SelenideElement fieldUserEmail;

    @FindBy(how= How.XPATH, using = ".//nav//button[text()='Выход']")
    private SelenideElement btnLogoutPersonalAccount;


    public void isOpenPersonalAccountPage() {
        webdriver().shouldHave(url(URL_ACCOUNT));
    }

    public void isEqualsUserNameExpectedName(String name) {
        fieldUserName.shouldHave(Condition.value(name));
    }

    public void isEqualsUserEmailExpectedEmail(String email) {
        fieldUserEmail.shouldHave(Condition.value(email));
    }

    public void clickBtnLogoutPersonalAccount () {
        btnLogoutPersonalAccount.click();
    }


}
