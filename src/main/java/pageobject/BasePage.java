package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {

    @FindBy(how= How.XPATH,using=".//a/p[text()='Конструктор']")
    private SelenideElement btnLinkBurgerConstructor;

    @FindBy(how= How.XPATH,using=".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']")
    private SelenideElement logoStellarBurger;

    @FindBy(how= How.XPATH,using="//a/p[text()='Личный Кабинет']")
    private SelenideElement btnLinkPersonalAccount;

    public void clickBtnLinkBurgerContractor() {
        btnLinkBurgerConstructor.click();
    }

    public void clickLogoStellarBurger() {
        logoStellarBurger.click();
    }

    public void clickBtnLinkToProfile() {
        btnLinkPersonalAccount.click();
    }

}
