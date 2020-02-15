package task.steps;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import task.pages.ProductCard;

import java.util.ArrayList;
import java.util.List;

public class ProductCardSteps extends BaseTest {
    public List<ProductCard> collectInfoAboutAllProducts(WebElement element) {
        List<ProductCard> products = new ArrayList<>();
        String name = element.findElement(By.xpath("./../../../../..//a[text()]")).getText();
        String priceTrial = element.findElement(By.xpath("./../../../..//span[text()]")).getText()
                .replaceAll("\\D", "");
        int price = Integer.parseInt(priceTrial);
        ProductCard productCard = new ProductCard(name, price);
        products.add(productCard);
        return products;
    }

    public void checkProductsAddedCorrect(List<ProductCard> productsFromSearch) {
        for(ProductCard card : productsFromSearch) {
            String neededName = card.getTitle();
            WebElement product = driver.findElement(By.xpath("//span[contains(text(), '" + neededName + "')]"));
            Assert.assertTrue(product.isDisplayed());
        }
    }

}
