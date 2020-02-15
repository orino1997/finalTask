package task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends OzonHomePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//span[contains(text(), 'Ваша корзина')]/..//span[contains(text(), 'товар')]")
    public WebElement amountOfProductsInCart;

    @FindBy(xpath = " //span[contains(text(), 'Удалить выбранные')]")
    public WebElement deleteAllProductsButton;

    @FindBy(xpath = " //div[contains(text(), 'Удаление товаров')]")
    public WebElement deleteAllPopUpTitle;

    @FindBy(xpath = " //div[contains(text(), 'Удалить')]")
    public WebElement deleteInPopUp;

    @FindBy(xpath = " //h1[contains(text(), 'Корзина пуста')]")
    public WebElement emptyCartTitile;

}
