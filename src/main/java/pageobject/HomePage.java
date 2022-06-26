package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
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

    @Step("Нажать на кнопку Войти в аккаунт на главной")
    public void clickBtnLoginInHomePage() {
        btnLoginInHomePage.shouldBe(Condition.visible).click();
    }

    @Step("Нажать на таб Булки в конструкторе Соберите бургер")
    public void clickTabBanInConstructor() {
        tabBanConstructor.click();
        headerBanConstructor.shouldBe(Condition.visible);
    }

    @Step("Нажать на таб Соусы в конструкторе Соберите бургер")
    public void clickTabSouseInConstructor() {
        tabSouseConstructor.click();
        headerSouseConstructor.shouldBe(Condition.visible);
    }

    @Step("Нажать на таб Начинки в конструкторе Соберите бургер")
    public void clickTabFillingsInConstructor () {
        tabFillingsConstructor.click();
        headerFillingsConstructor.shouldBe(Condition.visible);
    }

    @Step("Проверить, что открыта главная с конструктором Соберите бургер")
    public void isOpenHomePage() {
        webdriver().shouldHave(url(URL));
    }

    @Step("Проверить, что кнопка Оформить заказ присутствует на странице")
    public void isBtnMakeOrderInHomePageVisible() {
        btnMakeOrderInHomePage.should(Condition.exist);
    }

    @Step("Проверить, что открыта главная страница с конструктором Соберите бургер и на сранице присутствует кнопка Оформить заказ")
    public void isOpenHomePageForAuthUser() {
        isOpenHomePage();
        isBtnMakeOrderInHomePageVisible();
    }

    @Step("Получить позицию на странице по вертикали заголовка Соусы в конструкторе Соберите бургер")
    public Integer getHeaderSouseLocation() {
        return headerSouseConstructor.getLocation().getY();
    }

    @Step("Получить позицию на странице по вертикали заголовка Булки в конструкторе Соберите бургер")
    public Integer getHeaderBanLocation() {
        return headerSouseConstructor.getLocation().getY();
    }

    @Step("Получить позицию на странице по вертикали заголовка Начинки в конструкторе Соберите бургер")
    public Integer getHeaderFillingLocation() {
        return headerSouseConstructor.getLocation().getY();
    }

    @Step("Проверить, что позиция на странице по вертикали заголовка изменилась")
    public void isElementPositionChanged(int before,int actual) {
       MatcherAssert.assertThat("Позиция элемента заголовка на странице не изменилась после клика",actual,Matchers.not(Matchers.equalTo(before)));
    }


}
