package task.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.pages.GoodsListPage;
import task.pages.OzonHomePage;

public class FinalAutoTest extends BaseTest{
    @Before
    public void init() {
        initialize();
        wait = new WebDriverWait(driver,4);
    }

    @Когда("^Перейти на сервис \"(.+)\"$")
    public void getToWebSite(String url) {
        driver.navigate().to(url);
    }

    @Когда("^Закрыть всплывающее окно рекламы, если оно появилось$")
    public void closePopUp() {
        OzonPageSteps ozonPageSteps = new OzonPageSteps();
        ozonPageSteps.closePopUp();
    }

    @Когда("^Выполнить поиск по$")
    public void search(String itemName) {
        OzonPageSteps ozonPageSteps = new OzonPageSteps();
        ozonPageSteps.performSearch(itemName);
    }

    @Когда("^Ограничить \"(.+)\" до$")
    public void limitPrice(String fieldName, String priceLimit) {
        GoodsListPageSteps goodsListPageSteps = new GoodsListPageSteps();
        goodsListPageSteps.setSliderLimit(fieldName, priceLimit);
    }

    @Когда("^Отметить чекбокс \"(.+)\"$")
    public void tickCheckBox(String checkBoxName) {
        GoodsListPageSteps goodsListPageSteps = new GoodsListPageSteps();
        goodsListPageSteps.tickCheckBox(checkBoxName);
    }

    @Когда("^Выбрать следующие \"(.+)\": \"(.+)\", \"(.+)\"$")
    public void chooseMultiCheckBox(String checkBoxName, String item1, String item2) {
        GoodsListPageSteps goodsListPageSteps = new GoodsListPageSteps();
        goodsListPageSteps.multipleChoiceOfCheckBoxes(checkBoxName, item1, item2);
    }
    @Когда("^Добавить в корзину \"(.+)\" товары в количестве \"(.+)\"$")
    public void addToCart(String typeOfSearch, String amount) {
        GoodsListPageSteps goodsListPageSteps = new GoodsListPageSteps();
        goodsListPageSteps.putIntoCart(typeOfSearch, amount);
    }

    @Тогда("^Перейти в корзину и проверить, что количество товаров соответствует ранее переданному$")
    public void checkAmountInCart() {
        GoodsListPageSteps goodsListPageSteps = new GoodsListPageSteps();
        goodsListPageSteps.goToCart();
        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.checkAmount();
    }

    @Когда("^Проверить, что в корзине лежат добавленные ранее товары$")
    public void checkValuesInCart() {
        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.checkContent();
    }

    @Когда("^Удалить все товары из корзины$")
    public void deleteFromCart() {
        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.deleteAll();
    }

    @Тогда("^Проверить, что корзина пуста$")
    public void checkCartIsEmpty() {
        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.checkCartEmpty();
    }

    @After
    public void tearDown(Scenario scenario) {
        super.tearDown(scenario);
    }
}
