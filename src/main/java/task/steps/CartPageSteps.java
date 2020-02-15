package task.steps;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task.pages.CartPage;
import task.pages.ProductCard;

import java.util.List;

public class CartPageSteps extends BaseTest{
    CartPage cartPage = new CartPage(driver);
    List<ProductCard> productsFromSearch = GoodsListPageSteps.products;
    ProductCardSteps productCardSteps = new ProductCardSteps();

    public void checkAmount() {
        String s = String.valueOf(GoodsListPageSteps.size / 2);
        Assert.assertTrue(cartPage.amountOfProductsInCart.getText().contains(s));

    }

    public void checkContent() {
        productCardSteps.checkProductsAddedCorrect(productsFromSearch);
    }

    public void deleteAll() {
        cartPage.deleteAllProductsButton.click();
        wait.until(ExpectedConditions.visibilityOf(cartPage.deleteAllPopUpTitle));
        cartPage.deleteInPopUp.click();
    }


    public void checkCartEmpty() {
        Assert.assertTrue(cartPage.emptyCartTitile.isDisplayed());
    }
}
