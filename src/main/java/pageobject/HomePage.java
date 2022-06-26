package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HomePage extends BasePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']/following::div/button[text()='Войти в аккаунт']")
    private SelenideElement btnLoginInHomePage;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']/following::div/button[text()='Оформить заказ']")
    private SelenideElement btnMakeOrderInHomePage;

    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']/following::div/span[text()='Булки']")
    private SelenideElement tabBanConstructor;

    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']/following::div/span[text()='Соусы']")
    private SelenideElement tabSouseConstructor;

    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']/following::div/span[text()='Начинки']")
    private SelenideElement tabFillingsConstructor;

    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    private SelenideElement headerBanConstructor;

    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    private SelenideElement headerSouseConstructor;

    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    private SelenideElement headerFillingsConstructor;

    public void clickBtnLoginInHomePage() {
        btnLoginInHomePage.shouldBe(Condition.visible).click();
    }

    public void clickTabBanInConstructor() {
        tabBanConstructor.click();
        headerBanConstructor.shouldBe(Condition.visible);
    }

    public void clickTabSouseInConstructor() {
        tabSouseConstructor.click();
        headerSouseConstructor.shouldBe(Condition.visible);
    }

    public void clickTabFillingsInConstructor () {
        tabFillingsConstructor.click();
        headerFillingsConstructor.shouldBe(Condition.visible);
    }

    public Integer getHeaderSouseLocation() {
        return headerSouseConstructor.getLocation().getY();
    }

    public Integer getHeaderBanLocation() {
        return headerSouseConstructor.getLocation().getY();
    }

    public Integer getHeaderFillingLocation() {
        return headerSouseConstructor.getLocation().getY();
    }

    public void isElementPositionChanged(int before,int actual) {
       MatcherAssert.assertThat("Позиция элемента заголовка на странице не изменилась после клика",actual,Matchers.not(Matchers.equalTo(before)));
    }

    public void isOpenHomePage() {
        webdriver().shouldHave(url(URL));
    }

    public void isBtnMakeOrderInHomePageVisible() {
        btnMakeOrderInHomePage.shouldBe(Condition.visible);
    }

    public void isOpenHomePageForAuthUser() {
        isOpenHomePage();
        isBtnMakeOrderInHomePageVisible();
    }
}
