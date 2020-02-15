package task.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import task.pages.GoodsListPage;
import task.pages.ProductCard;

import java.util.ArrayList;
import java.util.List;

public class GoodsListPageSteps extends BaseTest {
    GoodsListPage goodsListPage = new GoodsListPage(driver);
    public static int size;
    public static List<ProductCard> products;
    public static ProductCardSteps productCardSteps = new ProductCardSteps();

    public void setSliderLimit(String name, String limit) {
        String xpath = "//div[contains(text(),'" + name +"')]";
        WebElement limitInput = driver.findElement(By.xpath(xpath + "/..//div[text()]//label[text()='до']/..//input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", limitInput);
        wait.until(ExpectedConditions.elementToBeClickable(limitInput));
        limitInput.click();
        limitInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        limitInput.sendKeys(limit);
        limitInput.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfAllElements(goodsListPage.sliderBlocks));
    }

    public void tickCheckBox(String checkBoxName) {
        String xpath = "//span[contains(text(), '" + checkBoxName + "')]";
        WebElement input = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.click();
        WebElement tag = driver
                .findElement(By.xpath("//div[@data-widget ='searchResultsSort']//span[contains(text(),'" + checkBoxName+ "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tag);
        wait.until(ExpectedConditions.visibilityOf(tag));
    }

    public void putIntoCart(String type, String amount) {
        products = new ArrayList<>();
        if (amount.equalsIgnoreCase("все")) {
            size = goodsListPage.buttons.size();
        } else {
            size = Integer.parseInt(amount) * 2;
            Assert.assertTrue(goodsListPage.buttons.size() > size);
        }
        if (type.equalsIgnoreCase("нечетные")) {
            for (int i = 0; i < size; i++) {
                if (i % 2 == 0) {
                    WebElement b = goodsListPage.buttons.get(i);
                    products = this.productCardSteps.collectInfoAboutAllProducts(b);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", b);
                    b.click();
                    wait.until(ExpectedConditions.invisibilityOf(b));
                }
            }
        } else if (type.equalsIgnoreCase("четные")) {
            for (int i = 0; i < size; i++) {
                if (i % 2 != 0) {
                    WebElement b = goodsListPage.buttons.get(i);
                    products = this.productCardSteps.collectInfoAboutAllProducts(b);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", b);
                    b.click();
                    //wait.until(ExpectedConditions.invisibilityOf(b));
                }
            }
        }
    }

    public void multipleChoiceOfCheckBoxes(String name, String...e) {
        String fieldNameXpath = "//div[contains(text(), '" + name + "')]";
        driver.findElement(By.xpath(fieldNameXpath + "/..//span[contains(text(),'Посмотреть все')]")).click();
        for (String itemName : e) {
            WebElement input = driver.findElement(By.xpath("(" + fieldNameXpath + "/..//input)[1]"));
            input.click();
            input.sendKeys(Keys.chord(Keys.CONTROL,"a"));
            input.sendKeys(Keys.BACK_SPACE);
            input.sendKeys(itemName);
            WebElement resultCheckBox = driver.findElement(By.xpath("//span[contains(text(),'" + itemName + "')]"));
            wait.until(ExpectedConditions.visibilityOf(resultCheckBox));
            resultCheckBox.click();
        }
    }

    public void goToCart() {
        goodsListPage.cartButton.click();
    }
}
