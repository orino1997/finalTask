package task.steps;

import io.qameta.allure.Attachment;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import task.pages.ProductCard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductCardSteps extends BaseTest {
    public ProductCard collectInfoAboutProduct(WebElement element) {
        String name = element.findElement(By.xpath("./../../../../..//a[text()]")).getText();
        String priceTrial = element.findElement(By.xpath("./../../../..//span[text()]")).getText()
                .replaceAll("\\D", "");
        int price = Integer.parseInt(priceTrial);
        ProductCard productCard = new ProductCard(name, price);
        return productCard;
    }

    public void checkProductsAddedCorrect(List<ProductCard> productsFromSearch) {
        for(ProductCard card : productsFromSearch) {
            String neededName = card.getTitle();
            WebElement product = driver.findElement(By.xpath("//span[contains(text(), '" + neededName + "')]"));
            Assert.assertTrue(product.isDisplayed());
        }
    }

    @Attachment
    public static byte[] getFile(String sourceName) throws IOException {
        return Files.readAllBytes(Paths.get("", sourceName));
    }

    public void productFile() throws IOException {
        File file = new File("productInfo.txt");
        List<ProductCard> productsForTXT = GoodsListPageSteps.products;
        FileWriter writer = new FileWriter(file);
        StringBuilder string = new StringBuilder();
        productsForTXT.sort(Comparator.comparingInt(ProductCard::getPrice));
        Collections.reverse(productsForTXT);
        string.append("The most expensive: ");
        for(ProductCard product : productsForTXT) {
            String title = product.getTitle();
            int price = product.getPrice();
            string.append(price);
            string.append(" ");
            string.append(title);
            string.append("\n");
        }
        writer.write(String.valueOf(string));
        writer.close();
        getFile(file.getName());
    }
}
