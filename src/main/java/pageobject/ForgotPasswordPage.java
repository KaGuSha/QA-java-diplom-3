package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends BasePage {
    public static final String URL_FORGOT =  "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how= How.XPATH,using=".//p[text()='Вспомнили пароль?']/a[text()='Войти']")
    private SelenideElement bntLinkLoginInForgotPage;

    @Step("Нажать на ссылку Войти")
    public void clickBntLinkLoginInForgotPage() {
        bntLinkLoginInForgotPage.shouldBe(Condition.visible).click();
    }
}
