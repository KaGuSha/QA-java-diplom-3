package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {

    @FindBy(how= How.XPATH,using=".//a/p[text()='Конструктор']")
    private SelenideElement btnLinkBurgerConstructor;

    @FindBy(how= How.XPATH,using=".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']")
    private SelenideElement logoStellarBurger;

    @FindBy(how= How.XPATH,using="//a/p[text()='Личный Кабинет']")
    private SelenideElement btnLinkPersonalAccount;

    @Step("Нажать на ссылку Конструктор в header")
    public void clickBtnLinkBurgerContractor() {
        btnLinkBurgerConstructor.click();
    }

    @Step("Нажать на логотип StellarBurger в header")
    public void clickLogoStellarBurger() {
        logoStellarBurger.click();
    }

    @Step("Нажать на кнопку Личный кабинет в header")
    public void clickBtnLinkToProfile() {
        btnLinkPersonalAccount.click();
    }
}
